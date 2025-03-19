
INSERT INTO user_person (first_name, last_name, email, password, phone_number, date_of_birth)
VALUES ( 'John', 'Doe', 'john.doe@example.com', 'sa', '123456789', '1990-05-10');

INSERT INTO owner (id, address)
VALUES (1, '123 Farm Street');


INSERT INTO cattle (identification_number, gender, breed, weight, date_of_birth, status, is_calf, owner_id, mother_id)
VALUES (1001, 'female', 'Holstein', 650.5, '2020-06-12', 'lactating', TRUE, 1, NULL);

INSERT INTO cattle (identification_number, gender, breed, weight, date_of_birth, status, is_calf, owner_id, mother_id)
VALUES (1002, 'male', 'Angus', 720.0, '2021-08-15', 'breeding bull', FALSE, 1, NULL);

INSERT INTO cattle (identification_number, gender, breed, weight, date_of_birth, status, is_calf, owner_id, mother_id)
VALUES (1003, 'female', 'Jersey', 480.0, '2023-01-05', 'calf', TRUE, 1, null);

INSERT INTO cattle (identification_number, gender, breed, weight, date_of_birth, status, is_calf, owner_id, mother_id)
VALUES (1004, 'female', 'Simmental', 500.0, '2022-09-30', 'heifer', TRUE, 1,null);
