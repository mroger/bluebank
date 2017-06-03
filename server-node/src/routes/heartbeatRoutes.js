let heartbeatRouter = require('express').Router();

let router = function() {

    heartbeatRouter.route('/')
        .get(function(req, res) {
            res.status(200).json('OK');
        });

    return heartbeatRouter;
}

module.exports = router;