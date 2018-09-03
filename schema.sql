
CREATE DATABASE IF NOT EXISTS car_repair_CRM;


CREATE TABLE IF NOT EXISTS employee (
  id            INT AUTO_INCREMENT,
  forename      VARCHAR(80),
  surname       VARCHAR(80),
  address       VARCHAR(200),
  phone_number  VARCHAR(16),
  note          VARCHAR(300),
  hour_salary   DOUBLE,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS customer (
  id            INT AUTO_INCREMENT,
  forename      VARCHAR(80),
  surname       VARCHAR(80),
  phone_number  VARCHAR(16),
  birth_date    DATE,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS vehicle
(
  id                  INT AUTO_INCREMENT,
  model               VARCHAR(50),
  brand               VARCHAR(50),
  production_year     INT(4),
  registration_number VARCHAR(10) UNIQUE,
  next_inspection     DATE,
  customer_id         INT,
    PRIMARY KEY (id),

  FOREIGN KEY (customer_id) references customer(id)
);


CREATE TABLE IF NOT EXISTS order (
  id                     INT AUTO_INCREMENT,
  receive_date           DATE,
  planned_start_date     DATE,
  start_date             DATE,
  end_date               DATE,
  employee_id            INT,
  problem_description    VARCHAR(500),
  repair_description     VARCHAR(500),
  status                 VARCHAR(20),
  vehicle_id             INT,
  client_costs           DOUBLE,
  parts_cost             DOUBLE,
  service_cost_per_hour  DOUBLE,
  hours_amount           DOUBLE,
  PRIMARY KEY (id),
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);
