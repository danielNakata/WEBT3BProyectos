/* 
 * Codigo angular para la aplicacion
 */
var aplicaciones;


(function(){
    aplicaciones = angular.module('listaApps', []);
    
    var listaAppGlob;
    /**
     * Factory que realiza la busqueda de la informacion
     */
    aplicaciones.factory('ListaAppsFactory', function($q, $http){
        var get = function(search){
            var deferred = $q.defer();
            $http.get("actions/consultaAplicaciones.jsp").
                    success(function(data, status, headers, config){
                        deferred.resolve(data);
            }).error(function(data, status, headers, config){
                deferred.reject(status);
            });
            return deferred.promise;
        };
        
        return { get: get };
    });
    
    /**
     * Factory que realiza la busqueda de la informacion de los responsables
     */
    aplicaciones.factory('ListaResponsablesFactory', function($q, $http){
        var get = function(search){
            var deferred = $q.defer();
            $http.get("actions/consultaResponsables.jsp").
                    success(function(data, status, headers, config){
                        deferred.resolve(data);
            }).error(function(data, status, headers, config){
                deferred.reject(status);
            });
            return deferred.promise;
        };
        
        return { get: get };
    });
    
    
    aplicaciones.factory('ListaLogDescargasFactory', function($q, $http){
        var get = function(search){
            var deferred = $q.defer();
            $http.get("actions/consultaLogDescargas.jsp").
                    success(function(data, status, headers, config){
                        deferred.resolve(data);
            }).error(function(data, status, headers, config){
                deferred.reject(status);
            });
            return deferred.promise;
        };
        
        return { get: get };
    });
        
    /**
     * Evento del controller que realiza la busqueda, obtiene el promise y pinta los datos
     */
    aplicaciones.controller('listaAppsController', function($scope, $http, $window, ListaAppsFactory){
        $scope.$watch('search', function(newValue, oldValue){
            var promesa = ListaAppsFactory.get(newValue);
            promesa.then(function(value){
                listaAppGlob = value;
                $scope.apps = value;
            }, function(reason){
                $scope.error = reason;
            });
            /**
             * Evento del boton de descarga
             * @param {type} idApp
             * @param {type} usuario
             * @param {type} ipdescarga
             * @param {type} rutaDescarga
             * @returns {undefined}
             */
            $scope.realizaDescargaApp = function(idApp, usuario, ipdescarga, rutaDescarga){
                $http({
                    method: 'GET',
                    url: 'registraDescarga?idApp='+idApp+"&slogin="+usuario+"&ipdescarga="+ipdescarga,
                }).success(function(data, status, headers, config){
                    var respuesta = data;
                    if(respuesta.res === '1'){
                        $window.location.href='apps/'+rutaDescarga;
                    }else{
                        alert(respuesta.msg);
                    }
                }).error(function(data, status, headers, config){
                    //alert("Error ");
                    var respuesta = data;
                    alert(respuesta.msg);
                });
            };
        });
    });
    
    /**
     * Evento del controller que realiza la busqueda, obtiene el promise y pinta los datos de los responsables
     */
    aplicaciones.controller('listaResponsablesController', function($scope, ListaResponsablesFactory){
        $scope.$watch('search', function(newValue, oldValue){
            var promesa = ListaResponsablesFactory.get(newValue);
            promesa.then(function(value){
                listaAppGlob = value;
                $scope.resps = value;
            }, function(reason){
                $scope.error = reason;
            });
        });
    });
    
    
    aplicaciones.controller('listaLogDescargasController', function($scope, ListaLogDescargasFactory){
        $scope.$watch('search', function(newValue, oldValue){
            var promesa = ListaLogDescargasFactory.get(newValue);
            promesa.then(function(value){
                listaAppGlob = value;
                $scope.resps = value;
            }, function(reason){
                $scope.error = reason;
            });
            
            $scope.sort = {
                sortingOrder: 'fechadescarga',
                reverse: false
            };
            
            $scope.gap = 10;
            
            $scope.filteredItems = [];
            $scope.groupedItems = [];
            $scope.itemsPerPage = 10;
            $scope.pagedItems = [];
            $scope.currentPage = 0;
            $scope.items = $scope.resps.datos;
            
            $scope.range = function (size,start, end) {
                var ret = [];        
                console.log(size,start, end);

                if (size < end) {
                    end = size;
                    start = size-$scope.gap;
                }
                for (var i = start; i < end; i++) {
                    ret.push(i);
                }        
                 console.log(ret);        
                return ret;
            };
            
            $scope.prevPage = function () {
                if ($scope.currentPage > 0) {
                    $scope.currentPage--;
                }
            };

            $scope.nextPage = function () {
                if ($scope.currentPage < $scope.pagedItems.length - 1) {
                    $scope.currentPage++;
                }
            };

            $scope.setPage = function () {
                $scope.currentPage = this.n;
            };
            
        });
    });
    
    
    aplicaciones.controller('ControlTab', function(){
        this.tab = '1';
        this.setTab = function(tab1){
            this.tab = tab1;
        };
        this.isSetTab = function(tab){
            return this.tab === tab;
        };
    });
    
    
})();


