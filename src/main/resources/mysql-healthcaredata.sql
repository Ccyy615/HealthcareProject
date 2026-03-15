-- //////////////////////////////////////////
-- Data for patients
-- //////////////////////////////////////////

--1
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender,contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country,insurancenumber, allergy, blood_type, patient_status)
VALUES (1, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6', 'John Smith', '1985-03-15', 'M', 'john.smith@example.com', '514-555-0101', '123 Maple St', 'Montreal', 'Quebec', 'H1A1A1', 'Canada', 'INS-1001', 'Peanuts', 3, 0);

--2
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender,contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (2, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4s9m2', 'Emily Johnson', '1990-07-22', 'F', 'emily.johnson@example.com', '514-555-0102', '456 Oak St', 'Laval', 'Quebec', 'H7B2B2', 'Canada', 'INS-1002', 'None', 0, 0);

--3
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (3, 'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8', 'Michael Brown', '1978-11-05', 'M', 'michael.brown@example.com', '514-555-0103', '789 Pine St', 'Toronto', 'Ontario', 'M5C1C1', 'Canada', 'INS-1003', 'Gluten', 2, 0);

--4
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender,contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (4, 'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9', 'Sarah Davis', '1995-01-18', 'F', 'sarah.davis@example.com', '514-555-0104', '321 Birch St', 'Montreal', 'Quebec', 'H2D3D3', 'Canada', 'INS-1004', 'Penicillin', 2, 0);

--5
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (5, 'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0', 'David Lee', '1982-05-30', 'M', 'david.lee@example.com', '514-555-0105', '654 Cedar St', 'Toronto', 'Ontario', 'M4E2E2', 'Canada', 'INS-1005', 'None', 1, 0);

--6
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (6, 'b6c7d8e9-f0a1-b2c3-d4e5-f6a7b8c9d0e1', 'Laura Wilson', '1998-09-12', 'F', 'laura.wilson@example.com', '514-555-0106', '987 Spruce St', 'Laval', 'Quebec', 'H7C3C3', 'Canada', 'INS-1006', 'Latex', 0, 0);

--7
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender,contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country, insurancenumber, allergy, blood_type, patient_status)
VALUES (7, 'c7d8e9f0-a1b2-c3d4-e5f6-a7b8c9d0e1f2', 'James Martin', '1975-02-25', 'M', 'james.martin@example.com', '514-555-0107', '246 Elm St', 'Montreal', 'Quebec', 'H1B4B4', 'Canada', 'INS-1007', 'Shellfish', 2, 0);

--8
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country,insurancenumber, allergy, blood_type, patient_status)
VALUES (8, 'd8e9f0a1-b2c3-d4e5-f6a7-b8c9d0e1f2a3', 'Olivia Thompson', '1988-08-08', 'F', 'olivia.thompson@example.com', '514-555-0108', '135 Walnut St', 'Toronto', 'Ontario', 'M5B5B5', 'Canada', 'INS-1008', 'None', 3, 0);

--9
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country,insurancenumber, allergy, blood_type, patient_status)
VALUES (9, 'e9f0a1b2-c3d4-e5f6-a7b8-c9d0e1f2a3b4', 'William Garcia', '1992-12-19', 'M', 'william.garcia@example.com', '514-555-0109', '864 Chestnut St', 'Montreal', 'Quebec', 'H3E4E4', 'Canada', 'INS-1009', 'Peanuts', 1, 0);

--10
INSERT INTO patients(id, pateint_id, full_name, date_of_birth, gender, contact_email, contact_phone, contact_address_street, contact_address_city,
                     contact_address_province, contact_address_postalcode, contact_address_country,insurancenumber, allergy, blood_type, patient_status)
VALUES (10, 'f0a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'Sophia Martinez', '2000-04-27', 'F', 'sophia.martinez@example.com', '514-555-0110', '579 Poplar St', 'Laval', 'Quebec', 'H7D5D5', 'Canada', 'INS-1010', 'None', 0, 0);


-- //////////////////////////////////////////
-- Data for doctors
-- //////////////////////////////////////////
INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (1, 'DOC-001', 'John', 'Smith', TRUE, TRUE, 'Montreal', 'Quebec');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (2, 'DOC-002', 'Emily', 'Chen', TRUE, TRUE, 'Laval', 'Quebec');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (3, 'DOC-003', 'Michael', 'Brown', TRUE, TRUE, 'Toronto', 'Ontario');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (4, 'DOC-004', 'Sarah', 'Johnson', TRUE, TRUE, 'Montreal', 'Quebec');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (5, 'DOC-005', 'David', 'Lee', TRUE, TRUE, 'Toronto', 'Ontario');


-- Doctor Specialities
INSERT INTO doctor_specialities (id, speciality_name, proficiency_level)
VALUES (1, 'Pediatrics', 'EXPERT'),
       (1, 'Cardiology', 'BEGINNER');

INSERT INTO doctor_specialities (id, speciality_name, proficiency_level)
VALUES (2, 'Cardiology', 'EXPERT');

INSERT INTO doctor_specialities (id, speciality_name, proficiency_level)
VALUES (3, 'Dermatology', 'INTERMEDIATE');

INSERT INTO doctor_specialities (id, speciality_name, proficiency_level)
VALUES (4, 'Neurology', 'ADVANCED');

INSERT INTO doctor_specialities (id, speciality_name, proficiency_level)
VALUES (5, 'General Medicine', 'BEGINNER');


-- License
INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (24001, 'Pediatrics Board License', 'DOC-001', 'VALID', '2022-01-15', '2027-01-15');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (25502, 'Cardiology Practice License', 'DOC-002', 'VALID', '2021-06-10', '2026-06-10');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (82004, 'Dermatology Practice License', 'DOC-003', 'VALID', '2023-03-20', '2028-03-20');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (10302, 'Neurology Specialist License', 'DOC-004', 'EXPIRED', '2018-09-05', '2023-09-05');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (41053, 'General Medicine Practice License', 'DOC-005', 'EXPIRED', '2020-11-12', '2025-11-12');


-- //////////////////////////////////////////
-- Data for clinic available schedule
-- //////////////////////////////////////////

-- Clinic 1 (Doctor 1)
INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration, day_of_week, clinic_start_time, clinic_end_time, blocked_start_time, blocked_end_time)
VALUES
    (1, 'DOC-001', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'MONDAY', '08:00', '17:00', '10:00', '10:30'),
    (1, 'DOC-001', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'TUESDAY', '09:00', '17:00', '11:00', '11:30'),
    (1, 'DOC-004', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'WEDNESDAY', '08:00', '21:00', '12:30', '13:00'),
    (1, 'DOC-001', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'THURSDAY', '09:00', '15:00', NULL, NULL),
    (1, 'DOC-004', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'FRIDAY', '08:00', '17:00', '09:00', '09:15'),
    (1, 'DOC-004', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30, 'SATURDAY', '09:00', '15:00', NULL, NULL),
    (1, 'DOC-001', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'CLOSED', FALSE, 30, 'SUNDAY', 'CLOSED', 'CLOSED', NULL, NULL);


-- Clinic 2 (Doctor 2)
INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration, day_of_week, clinic_start_time, clinic_end_time, blocked_start_time, blocked_end_time)
VALUES
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'OPEN', TRUE, 20, 'MONDAY', '09:00', '15:00', NULL, NULL),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'OPEN', TRUE, 30, 'TUESDAY', '09:00', '15:00', '12:00', '12:30'),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'CLOSED', FALSE, 20, 'WEDNESDAY', 'CLOSED', 'CLOSED', NULL, NULL),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'OPEN', TRUE, 20, 'THURSDAY', '09:00', '15:00', NULL, NULL),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'CLOSED', FALSE, 20, 'FRIDAY', 'CLOSED', 'CLOSED', NULL, NULL),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'CLOSED', FALSE, 20, 'SATURDAY', 'CLOSED', 'CLOSED', NULL, NULL),
    (2, 'DOC-002', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'CLOSED', FALSE, 20, 'SUNDAY', 'CLOSED', 'CLOSED', NULL, NULL);


-- Clinic 3 (Doctor 3)
INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration, day_of_week, clinic_start_time, clinic_end_time, blocked_start_time, blocked_end_time)
VALUES
    (3, 'DOC-003', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 40, 'MONDAY', '09:00', '17:00', '12:00', '13:15'),
    (3, 'DOC-005', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 30, 'TUESDAY', '13:00', '17:00', '12:00', '13:15'),
    (3, 'DOC-005', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 15, 'WEDNESDAY', '13:00', '17:00', '12:00', '13:15'),
    (3, 'DOC-005', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 30, 'THURSDAY', '13:00', '17:00', NULL, NULL),
    (3, 'DOC-003', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 15, 'FRIDAY', '13:00', '17:00', '12:00', '13:15'),
    (3, 'DOC-003', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 15, 'SATURDAY', '12:00', '17:00', '12:00', '13:15'),
    (3, 'DOC-003', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 40, 'SUNDAY', '12:00', '17:00', '12:00', '13:15');


-- //////////////////////////////////////////
-- Data for booking appointment
-- //////////////////////////////////////////

-- //////////////////////////////////////////
-- Data for medical note
-- //////////////////////////////////////////
