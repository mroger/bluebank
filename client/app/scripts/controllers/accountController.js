'use strict';

/**
 * @ngdoc function
 * @name bluebankApp.controller:AccountCtrl
 * @description
 * # AccountCtrl
 * Controller of the bluebankApp
 */
angular.module('bluebankApp')
  .controller('AccountCtrl', ['$scope', 'accountService', '$log', function ($scope, accountService, $log) {
    var ctrl = this;

    ctrl.transfer = function(transferData) {
      $log.debug(transferData);
      $log.debug('controller...');
      accountService.transfer(transferData);
    };

  }]);
