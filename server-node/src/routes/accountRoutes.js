const logger = require("../../lib/logger");
const AccountService = require('../../lib/account');
const Account = new AccountService();
const accountRouter = require('express').Router();
const AccountError = require('../../lib/errors/accountError.js');

let router = () => {
    accountRouter.route('/')
        .post( (req, res) => {

            if (!req.body.number)
                return res.status(400).json('Bad Request - number is required.');
            
            Account.post(req.body.number, req.body.agency, req.body)
            .then(account => {
                res.location('/accounts/' + account._id);
                return res.status(201).json(account);
            })
            .catch(AccountError, error => {
                logger.debug('AccountError occurred', error);
                res.location('/accounts/' + error.extra.id);
                return res.status(409).json(error.extra);
            })
            .catch(error => {
                if (error) return res.status(500).json('Internal Server Error');
            });
        });

    return accountRouter;
};

module.exports = router;