```text

_______       _____                        _____     _________   ________              ______ _____                    ______       _____ 
___    |___  ___  /_____________ _________ __  /___________  /   ___  __ \_____ __________  /____(_)_____________ _    ___  / ________  /_
__  /| |  / / /  __/  __ \_  __ `__ \  __ `/  __/  _ \  __  /    __  /_/ /  __ `/_  ___/_  //_/_  /__  __ \_  __ `/    __  /  _  __ \  __/
_  ___ / /_/ // /_ / /_/ /  / / / / / /_/ // /_ /  __/ /_/ /     _  ____// /_/ /_  /   _  ,<  _  / _  / / /  /_/ /     _  /___/ /_/ / /_  
/_/  |_\__,_/ \__/ \____//_/ /_/ /_/\__,_/ \__/ \___/\__,_/      /_/     \__,_/ /_/    /_/|_| /_/  /_/ /_/_\__, /      /_____/\____/\__/  
                                                                                                          /____/                          

```

## Description
Application which appoints slots to cars in a multi-storeyed parking lot.
Features supported:
* Create parking slots
* Automatically allot parking slots nearest to the entrance
* Allow users to leave the parking slot
* Searches
   * Show details of parked cars
   * Show details of cars for a specific color
   * Show parking slots occupied by cars of a specific color
   * Show parking slot id for a particular car
   
   
###### Requires
* Java 9
* Maven 3.3
   

This project can be run locally :

     parking_lot.sh  or parking_lot.bat

If you want to pass the input as a text document:

     parking_lot.sh <path_to_file>  or parking_lot.bat <path_to_file>
