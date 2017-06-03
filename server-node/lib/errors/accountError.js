'use strict';

function AccountError(message, extra) {
  this.message = message;
  this.name = "AccountError";
  this.extra = extra;
  Error.captureStackTrace(this, AccountError);
};
AccountError.prototype = Object.create(Error.prototype);
AccountError.prototype.constructor = AccountError;

exports = module.exports = AccountError;