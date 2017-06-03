const winston = require('winston');
const config = require('../configuration')();

const logger = new (winston.Logger)({
    transports: [
      new (winston.transports.Console)({
        level: config.get('logger:level')
      }),
      new (winston.transports.File)({
        filename: config.get('logger:filename'),
        maxsize: 1048576,
        maxFiles: 3,
        level: config.get('logger:level')
      })
    ]
  });

module.exports = logger;