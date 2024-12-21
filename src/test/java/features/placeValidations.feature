Feature: Validating Place API's

  @AddPlace @Regression
  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload with "<name>"  "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name    | language | address              |
      | Saurabh | Kannada  | WhiteField Bengaluru |
      | Saurabh | Spanish  | Barcelona            |

  @GetPlace @Regression
  Scenario Outline: Verify if Place is being successfully fetched using GetPlaceAPI
    Given GetPlace Payload with "<PlaceId>"
    When user calls "getPlaceAPI" with "GET" http request
    Then the API call got success with status code 200


    Examples:
      | PlaceId                          |
      | 285205df81f7a9179e878f35b86cc5ed |
      | ed411b09b70ddb46414e927b879d597e |

  @UpdatePlace @Regression
  Scenario Outline: Verify if Place is being Succesfully updated using updatePlaceAPI
    Given UpdatePlace Payload with "<PlaceId>", "<address>" and key "qaclick123"
    When user calls "updatePlaceAPI" with "PUT" http request
    Then the API call got success with status code 200
    And "msg" in response body is "Address successfully updated"

    Examples:
      | PlaceId                          | address |
      | ed411b09b70ddb46414e927b879d597e | Berlin City, Germany |


  @DeletePlace @Regression
  Scenario: Verify if Delete Place functionality is working

    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"



  #This will delete a specific place set by user
  @DeleteSpecificPlace
  Scenario Outline: Verify if Delete Place functionality for a specific place id is working

    Given DeletePlace Payload with "<PlaceId>"
    When user calls "deletePlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

    Examples:
      | PlaceId                          |
      | e9246a3a2ae217567460e87f567db41f |


	

	
	
	
	
	
	

	
	
	