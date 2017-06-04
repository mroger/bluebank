const Promise = require("bluebird");
const logger = require("../logger");
const AccountSchema = require('../models').model('Account');
const AccountError = require('../errors/accountError.js');

function Account(){};

Account.prototype.create = (data) => {
    return new Promise((resolve, reject) => {
        const account = new AccountSchema(data);

        account.save()
        .then(acc => {
            return resolve(acc);
        })
        .catch(error => {
            return reject(error);
        });
    });
};

module.exports = Account;