angular.module("appCredito").controller("clienteController", function($scope, $routeParams, clienteFactory, $location){
    $scope.titulo = "Clientes";
    
    $scope.clientes = [];
    $scope.cliente = {};

    $scope.carregarClientes = function(){
    	clienteFactory.listar().then(function(clientes){
        $scope.clientes = clientes;
        });
    }
    
    $scope.adicionarCliente = function(){
    	clienteFactory.criarCliente($scope.cliente).then(function(cliente){
		$scope.carregarClientes();
		alert("Cadastra efetuado com sucesso!")
		$location.url("/cliente");
        });
    }
    
})