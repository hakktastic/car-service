package nl.hakktastic.leaseacarapi.testdata;

import nl.hakktastic.leaseacarapi.entity.Car;

public final class CarTestData {

  /** Car ID. */
  public static final int CAR_ID_VALID_1001 = 1001;

  public static final int CAR_ID_VALID_2891_FORD = 2891;
  public static final int CAR_ID_VALID_11329_VOLVO = 11329;

  public static final int CAR_ID_INVALID_0 = -10;

  /** Make. */
  public static final String MAKE_VALID_VOLVO = "Volvo";

  public static final String MAKE_VALID_LAND_ROVER = "Land Rover";

  public static final String MAKE_INVALID_TOO_SHORT = "A";
  public static final String MAKE_INVALID_TOO_LONG =
      "This is an invalid car make name with more than fifty characters";

  /** Model. */
  public static final String MODEL_VALID_DISCOVERY = "Discovery";

  public static final String MODEL_VALID_XC90 = "XC90";

  public static final String MODEL_INVALID_TOO_SHORT = "A";
  public static final String MODEL_INVALID_TOO_LONG =
      "This is an invalid car model name with more than fifty characters";

  /** Version. */
  public static final String VERSION_VALID_DISCOVERY = "2.0 Si4 HSE Luxury";

  public static final String VERSION_VALID_XC90 = "T8 Twin Eng AWD Geartr Inscription Intro";
  public static final String VERSION_INVALID_TOO_SHORT = "A";
  public static final String VERSION_INVALID_TOO_LONG =
      "This is an invalid car version name with more than fifty characters";

  /** Nr. of Doors. */
  public static final int NR_OF_DOORS_VALID_4 = 4;

  public static final int NR_OF_DOORS_VALID_5 = 5;

  public static final int NR_OF_DOORS_INVALID_1 = 1;
  public static final int NR_OF_DOORS_INVALID_6 = 6;

  /** Gross Prices. */
  public static double GROSS_PRICE_VALID_LAND_ROVER = 120205;

  public static double GROSS_PRICE_VALID_VOLVO = 90695;

  public static double GROSS_PRICE_INVALID_0 = 0;

  /** Nett Price. */
  public static double NETT_PRICE_VALID_LAND_ROVER = 68680.99;

  public static double NETT_PRICE_VALID_VOLVO = 71969.42;

  public static double NETT_PRICE_INVALID_0 = 0;

  /** HP. */
  public static int HP_VALID_LAND_ROVER = 300;

  public static int HP_VALID_VOLVO = 390;
  public static int HP_INVALID_0 = 0;

  /** Car Objects. */
  public static final Car CAR_OBJECT_INVALID_NO_ARGS = new Car().builder().build();

  public static final Car CAR_OBJECT_VALID_ALL_ARGS_LAND_ROVER =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_VALID_ALL_ARGS_VOLVO =
      new Car()
          .builder()
          .make(MAKE_VALID_VOLVO)
          .model(MODEL_VALID_XC90)
          .version(VERSION_VALID_XC90)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_VOLVO)
          .nettPrice(NETT_PRICE_VALID_VOLVO)
          .hp(HP_VALID_VOLVO)
          .build();

  public static final Car CAR_OBJECT_INVALID_MAKE_INVALID_TOO_SHORT =
      new Car()
          .builder()
          .make(MAKE_INVALID_TOO_SHORT)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_MAKE_INVALID_TOO_LONG =
      new Car()
          .builder()
          .make(MAKE_INVALID_TOO_LONG)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_MODEL_TOO_SHORT =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_INVALID_TOO_SHORT)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_MODEL_TOO_LONG =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_INVALID_TOO_LONG)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_VERSION_TOO_SHORT =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_INVALID_TOO_SHORT)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_VERSION_TOO_LONG =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_INVALID_TOO_LONG)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_NR_OF_DOORS_1 =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_INVALID_1)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_NR_OF_DOORS_6 =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_INVALID_6)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_GROSS_PRICE =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_INVALID_0)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_NETT_PRICE =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_INVALID_0)
          .hp(HP_VALID_LAND_ROVER)
          .build();

  public static final Car CAR_OBJECT_INVALID_HP =
      new Car()
          .builder()
          .make(MAKE_VALID_LAND_ROVER)
          .model(MODEL_VALID_DISCOVERY)
          .version(VERSION_VALID_DISCOVERY)
          .numberOfDoors(NR_OF_DOORS_VALID_5)
          .grossPrice(GROSS_PRICE_VALID_LAND_ROVER)
          .nettPrice(NETT_PRICE_VALID_LAND_ROVER)
          .hp(HP_INVALID_0)
          .build();
}
