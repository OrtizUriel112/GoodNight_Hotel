CREATE TABLE guest_type(
    guest_type_id INT GENERATED ALWAYS AS IDENTITY,
   	name VARCHAR NOT NULL,
  	PRIMARY KEY(guest_type_id)
);

CREATE TABLE guest(
    guest_id INT GENERATED ALWAYS AS IDENTITY,
  	guest_type_id INT,
   	first_name VARCHAR NOT NULL,
  	last_name VARCHAR NOT NULL,
  	email VARCHAR NOT NULL,
  	PRIMARY KEY(guest_id),
  	CONSTRAINT fk_guest_type
      FOREIGN KEY(guest_type_id)
	  REFERENCES guest_type(guest_type_id)
);

CREATE TABLE hotel(
    hotel_id INT GENERATED ALWAYS AS IDENTITY,
   	name VARCHAR NOT NULL,
  	description VARCHAR NOT NULL,
  	stars INT,
  	PRIMARY KEY(hotel_id)
);

CREATE TABLE room_type(
    room_type_id INT GENERATED ALWAYS AS IDENTITY,
   	name VARCHAR NOT NULL,
  	PRIMARY KEY(room_type_id)
);

CREATE TABLE room(
    room_id INT GENERATED ALWAYS AS IDENTITY,
  	room_type_id INT,
  	hotel_id INT,
   	name VARCHAR NOT NULL,
  	description VARCHAR NOT NULL,
  	floor INT,
  	max_guests INT,
  	PRIMARY KEY(room_id),
  	CONSTRAINT fk_room_type
      FOREIGN KEY(room_type_id)
	  REFERENCES room_type(room_type_id),
  	CONSTRAINT fk_hotel
      FOREIGN KEY(hotel_id)
	  REFERENCES hotel(hotel_id)
);

CREATE TABLE reservation(
    reservation_id INT GENERATED ALWAYS AS IDENTITY,
  	room_id INT,
  	guest_id INT,
   	start_date DATE NOT NULL DEFAULT CURRENT_DATE,
  	end_date DATE NOT NULL DEFAULT CURRENT_DATE,
  	check_in BOOLEAN,
    check_out BOOLEAN,
  	PRIMARY KEY(reservation_id),
  	CONSTRAINT fk_room
      FOREIGN KEY(room_id)
	  REFERENCES room(room_id),
  	CONSTRAINT fk_guest
      FOREIGN KEY(guest_id)
	  REFERENCES guest(guest_id)
);

CREATE TABLE bitacora_reservaciones(
    binnacle_reservations_id INT GENERATED ALWAYS AS IDENTITY,
   	hotel_name VARCHAR NOT NULL,
  	room_name VARCHAR NOT NULL,
  	guest_first_name VARCHAR NOT NULL,
  	guest_last_name VARCHAR NOT NULL,
  	guest_email VARCHAR NOT NULL,
  	start_date DATE NOT NULL DEFAULT CURRENT_DATE,
  	end_date DATE NOT NULL DEFAULT CURRENT_DATE,
  	PRIMARY KEY(binnacle_reservations_id)
);