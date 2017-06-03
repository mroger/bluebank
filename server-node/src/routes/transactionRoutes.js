let transactionRouter = require('express').Router();

let router = function() {

    transactionRouter.route('/')
        .get(function(req, res) {
            console.log('Doing a GET on transactionRouter');
            res.send('Return from GET');
        });

    transactionRouter.route('/')
        .post(function(req, res) {
            console.log('Doing a POST on transactionRouter');
            res.send('Return from POST');
        });

    return transactionRouter;
}

module.exports = router;