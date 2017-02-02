angular.module('TIYAngularApp', [])
   .controller('MasterController', function($scope, $http) {
        $scope.name = "Reece";
        $scope.color_list = ["RED", "PURPLE", "BLUE", "PINK", "GREEN", "YELLOW"];
        $scope.current_list = "RED";

        $scope.cpuSlot = {};
        $scope.cpuMap = {};
        $scope.result = {};


        $scope.get_cpu_slot = function() {
                    console.log("Cpu slot is active");
                    $scope.name = "Cpu Player";

                    $http.get("/mastermind.json")
                        .then(
                            function successCallback(response) {
                                console.log(response.data);
                                console.log("getting cpu slot from json");

                                  console.log("About to add the following Todo " + JSON.stringify($scope.cpuSlot));

                                $scope.cpuSlot = response.data;
                            },
                            function errorCallback(response) {
                                console.log("Unable to get data");
                            });
                };


                 $scope.getPlayerSlot = function() {
                                    console.log("Player slot is active");

                                    $http.get("/player-play.json")
                                        .then(
                                            function successCallback(response) {
                                                console.log(response.data);
                                                console.log("getting player slot from json");

                                                  console.log("About to add the following Todo " + JSON.stringify($scope.playerSlot));

                                                $scope.playerSlot = response.data;
                                            },
                                            function errorCallback(response) {
                                                console.log("Unable to get data");
                                            });
                                };

                                $scope.playerSlot = {}
                                $scope.myColor = {};
                                $scope.lastMove = {};

                                        $scope.make_color = function() {
                                            console.log("About to add the following color " + JSON.stringify($scope.color));

                                            $http.post("/make_color.json", $scope.myColor)
                                                .then(
                                                    function successCallback(response) {
                                                        console.log(response.data);
                                                        console.log("Adding data to scope");
                                                        $scope.playerSlot = response.data;
                                                    },
                                                    function errorCallback(response) {
                                                        console.log("Unable to get data");
                                                    });
                                        };

                                        $scope.playSlot = {};
                                        $scope.colorContainer = {};
                                        $scope.resultContainer = {};

                                        $scope.make_slot = function() {
                                                            console.log("Player slot is active");
                                                            console.log("Container object on the scope = ");
                                                            console.log(JSON.stringify($scope.colorContainer));

                                                            $http.post("/make_slot.json", $scope.colorContainer)
                                                                .then(
                                                                    function successCallback(response) {
                                                                        console.log(response.data);
                                                                        console.log("HELLO HELLO HELLOgetting player slot from json");

                                                                        $scope.resultContainer = response.data;
                                                                        console.log("HELLO HELLO HELLO JSON version of the container:");
                                                                        console.log(JSON.stringify($scope.resultContainer))
                                                                    },
                                                                    function errorCallback(response) {
                                                                        console.log("Unable to get data");
                                                                    });
                                                        };


                        $scope.white_black = function() {
                                            console.log("Cpu slot is active");
                                            $scope.name = "Cpu Player";

                                            $http.get("/white_black.json")
                                                .then(
                                                    function successCallback(response) {
                                                        console.log(response.data);
                                                        console.log("getting cpu slot from json");


                                                        $scope.playSlot = response.data;
                                                    },
                                                    function errorCallback(response) {
                                                        console.log("Unable to get data");
                                                    });
                                        };

    });
