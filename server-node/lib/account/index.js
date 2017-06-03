const Promise = require("bluebird");
const logger = require("../logger");
const AccountSchema = require('../models').model('Account');
const AccountError = require('../errors/accountError.js');

function Account(){};

Account.prototype.post = (number, agency, data) => {
    return new Promise((resolve, reject) => {
        const account = new AccountSchema(data);

        AccountSchema.findOne({
            number: number,
            agency: agency
        })
        .then(acc => {
            if (acc) {
                logger.debug('Account found: ' + acc);
                reject(new AccountError('Account already exists', {
                    id: acc._id,
                    number: acc.number,
                    agency: acc.agency,
                    balance: acc.balance,
                    message: 'Account already exists'
                }));
            } else {
                account.save()
                .then(acc => {
                    resolve(acc);
                })
                .catch((error) => {
                    logger.error('An error creating account has occurred', error);
                    reject(error);
                });
            }
        })
        .catch(error => {
            logger.error('An error finding account has occurred', error);
            reject(error);
        });
    });
};

module.exports = Account;