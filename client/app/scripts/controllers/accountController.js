'use strict';

/**
 * @ngdoc function
 * @name bluebankApp.controller:AccountCtrl
 * @description
 * # AccountCtrl
 * Controller of the bluebankApp
 */
angular.module('bluebankApp')
  .controller('AccountCtrl', ['accountService', function (accountService) {
    var ctrl = this;

    ctrl.transfer = function() {
      console.log('controller...');
      accountService.transfer();
    };

  }]);
