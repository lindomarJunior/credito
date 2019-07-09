var app = angular.module("appCredito",["ngRoute","checklist-model"]);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
    .when("/cliente", {
        templateUrl : "view/cliente.html",
        controller : "clienteController"
    }).when("/pedido/cadastrar", {
        templateUrl : "view/clienteCadastro.html",
        controller : "clienteController"
    }).otherwise({redirectTo: "/"});
    
    $locationProvider.html5Mode(true);
});