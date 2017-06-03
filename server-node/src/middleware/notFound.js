const logger = require("../../lib/logger");

exports.index = function(req, res, next) {
    logger.error('Not Found');
    res.status(404).json('Not Found.');
};