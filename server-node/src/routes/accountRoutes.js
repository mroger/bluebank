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
            
            Account.create(req.body)
            .then(account => {
                res.location('/accounts/' + account._id);
                return res.status(201).json(account);
            })
            .catch(error => {
                logger.error('An error creating account has occurred', error);
                if (error.name === 'MongoError' && error.code === 11000) {
                    return res.status(409).json({
                        number: req.body.number,
                        agency: req.body.agency,
                        message: 'Account already exists'
                    });
                } else {
                    return res.status(500).json('Internal Server Error');
                };
            });
        });

    return accountRouter;
};

module.exports = router;