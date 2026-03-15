-- //////////////////////////////////////////
-- Data for patients
-- //////////////////////////////////////////


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
