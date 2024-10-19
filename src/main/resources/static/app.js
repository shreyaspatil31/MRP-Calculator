angular.module('mrpApp', [])
    .controller('MrpController', function($scope, $http) {
        $scope.productName = '';
        $scope.quantity = 0;
        $scope.mrpResults = [];
        $scope.calculatingMrp = false;
        $scope.error = null;

        $scope.calculateMrp = function() {
            $scope.calculatingMrp = true;
            $scope.error = null;

            $http.get('/api/mrp/calculate', {
                params: {
                    productName: $scope.productName,
                    quantity: $scope.quantity
                }
            }).then(function(response) {
                $scope.mrpResults = response.data;
                $scope.calculatingMrp = false;
            }, function(error) {
                console.error('Error calculating MRP:', error);
                $scope.error = 'An error occurred while calculating MRP. Please try again.';
                $scope.calculatingMrp = false;
            });
        };
    });
