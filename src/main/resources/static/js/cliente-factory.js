angular.module("appCredito").factory("clienteFactory", function($q, $http){
	return{
		listar: function(){
			var promessa = $q.defer();

			$http.get("http://localhost:8080/cliente").then(function(result){
				var clientes = result.data;
				promessa.resolve(clientes);
			})

			return promessa.promise;
		},
		criarCliente: function(cliente){
			var promessa = $q.defer();

			$http.post("http://localhost:8080/cliente/salva", cliente).then(function(result){
				var cliente = result.data;
				promessa.resolve(cliente);
			})

			return promessa.promise;
		}
	};
})