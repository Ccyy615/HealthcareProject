-- //////////////////////////////////////////
-- Data for patients
-- //////////////////////////////////////////
--1
INSERT INTO patients(id, patient_id, full_name, date_of_birth, gender, contact_email, contact_phone, street, city,
                     province, postal_code, country, insurancenumber, allergy_substance, allergy_reaction, blood_type, patient_status)
VALUES (1, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6', 'John Smith', '1985-03-15', 'M', 'john.smith@example.com', '514-555-0101', '123 Maple St', 'Montreal', 'Quebec', 'H1A1A1', 'Canada', 'INS-1001', 'Peanuts','Anaphylaxis', 'AB', 'ACTIVE');

--2
INSERT INTO patients(id, patient_id, full_name, date_of_birth, gender,contact_email, contact_phone, street, city,
                     province, postal_code, country,insurancenumber, allergy_substance, allergy_reaction, blood_type, patient_status)
VALUES (2, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2', 'Emily Johnson', '1990-07-22', 'F', 'emily.johnson@example.com', '514-555-0102', '456 Oak St', 'Laval', 'Quebec', 'H7B2B2', 'Canada', 'INS-1002', 'None','Anaphylaxis', 'A', 'ACTIVE');

--3
INSERT INTO patients(id, patient_id, full_name, date_of_birth, gender,contact_email, contact_phone, street, city,
                     province, postal_code, country,insurancenumber, allergy_substance, allergy_reaction, blood_type, patient_status)
VALUES (3, 'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8', 'Michael Brown', '1978-11-05', 'M', 'michael.brown@example.com', '514-555-0103', '789 Pine St', 'Toronto', 'Ontario', 'M5C1C1', 'Canada', 'INS-1003', 'Gluten','Anaphylaxis', 'B', 'ACTIVE');

--4
INSERT INTO patients(id, patient_id, full_name, date_of_birth, gender, contact_email, contact_phone, street, city,
                     province, postal_code, country,insurancenumber, allergy_substance, allergy_reaction, blood_type, patient_status)
VALUES (4, 'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9', 'Sarah Davis', '1995-01-18', 'F', 'sarah.davis@example.com', '514-555-0104', '321 Birch St', 'Montreal', 'Quebec', 'H2D3D3', 'Canada', 'INS-1004', 'Penicillin','Anaphylaxis', '0', 'ACTIVE');

--5
INSERT INTO patients(id, patient_id, full_name, date_of_birth, gender,contact_email, contact_phone, street, city,
                     province, postal_code, country,insurancenumber, allergy_substance, allergy_reaction, blood_type, patient_status)
VALUES (5, 'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0', 'David Lee', '1982-05-30', 'M', 'david.lee@example.com', '514-555-0105', '654 Cedar St', 'Toronto', 'Ontario', 'M4E2E2', 'Canada', 'INS-1005', 'None','None', 'A', 'ACTIVE');

-- //////////////////////////////////////////
-- Data for doctors
-- //////////////////////////////////////////
INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (1, 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 'John', 'Smith', TRUE, TRUE, 'Montreal', 'Quebec');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (2, 'f2a3b4c5-d6e7-48f9-0a12-3456789bcdef', 'Emily', 'Chen', TRUE, TRUE, 'Laval', 'Quebec');

INSERT INTO doctors(id, doctor_id, first_name, last_name, is_active, is_valid, work_zone_city, work_zone_province)
VALUES (3, 'a3b4c5d6-e7f8-49a0-1b23-456789abcdef', 'Michael', 'Brown', TRUE, TRUE, 'Toronto', 'Ontario');


-- Doctor Specialities
INSERT INTO doctor_specialities (doctor_id, speciality_name, proficiency_level)
VALUES ('e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 'Pediatrics', 3);

INSERT INTO doctor_specialities (doctor_id, speciality_name, proficiency_level)
VALUES ('f2a3b4c5-d6e7-48f9-0a12-3456789bcdef', 'Cardiology', 3);

INSERT INTO doctor_specialities (doctor_id, speciality_name, proficiency_level)
VALUES ('a3b4c5d6-e7f8-49a0-1b23-456789abcdef', 'Dermatology', 1);
-- License
INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (24001, 'Pediatrics Board License', 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 0, '2022-01-15', '2027-01-15');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (25502, 'Cardiology Practice License', 'f2a3b4c5-d6e7-48f9-0a12-3456789bcdef', 0, '2021-06-10', '2026-06-10');

INSERT INTO doctor_license (license_id, license_name, doctor_id, status, performed_date, expiry_date)
VALUES (82004, 'Dermatology Practice License', 'a3b4c5d6-e7f8-49a0-1b23-456789abcdef', 0, '2023-03-20', '2028-03-20');


-- //////////////////////////////////////////
-- Data for clinic available schedule
-- //////////////////////////////////////////

INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration)
VALUES (1, 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd', '123 Main St', 'Montreal', 'Quebec', 'H1A2B3', 'OPEN', TRUE, 30);

INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration)
VALUES (2, 'f2a3b4c5-d6e7-48f9-0a12-3456789bcdef', '456 Elm St', 'Laval', 'Quebec', 'H7B4C5', 'OPEN', TRUE, 20);

INSERT INTO clinic_schedules
(clinic_id, doctor_id, clinic_location_street, clinic_location_city, clinic_location_province, clinic_location_postalcode,
 clinic_status, is_open, slot_duration)
VALUES (3, 'a3b4c5d6-e7f8-49a0-1b23-456789abcdef', '789 Pine St', 'Toronto', 'Ontario', 'M5C1A1', 'OPEN', TRUE, 40);

-- Clinic 1
INSERT INTO clinic_schedules_weekly_hours
(clinic_id, day_of_week, clinic_start_time, clinic_end_time)
VALUES
(1, 'MONDAY', '08:00', '17:00'),
(1, 'TUESDAY', '09:00', '17:00'),
(1, 'WEDNESDAY', '08:00', '17:00'),
(1, 'THURSDAY', '09:00', '15:00'),
(1, 'FRIDAY', '08:00', '17:00'),
(1, 'SATURDAY', '09:00', '15:00'),
(1, 'SUNDAY', NULL, NULL);

-- Clinic 2
INSERT INTO clinic_schedules_weekly_hours
(clinic_id, day_of_week, clinic_start_time, clinic_end_time)
VALUES
(2, 'MONDAY', '09:00', '15:00'),
(2, 'TUESDAY', '09:00', '15:00'),
(2, 'WEDNESDAY', NULL, NULL),
(2, 'THURSDAY', '09:00', '15:00'),
(2, 'FRIDAY', NULL, NULL),
(2, 'SATURDAY', NULL, NULL),
(2, 'SUNDAY', NULL, NULL);

-- Clinic 3
INSERT INTO clinic_schedules_weekly_hours
(clinic_id, day_of_week, clinic_start_time, clinic_end_time)
VALUES
(3, 'MONDAY', '09:00', '17:00'),
(3, 'TUESDAY', '09:00', '17:00'),
(3, 'WEDNESDAY', '09:00', '17:00'),
(3, 'THURSDAY', '09:00', '17:00'),
(3, 'FRIDAY', '09:00', '17:00'),
(3, 'SATURDAY', '10:00', '17:00'),
(3, 'SUNDAY', '10:00', '17:00');

-- Clinic 1
INSERT INTO clinic_schedules_blocked_slots(clinic_id, block_start_time, block_end_time)
VALUEs (1, '12:30', '13:00');

-- Clinic 2
INSERT INTO clinic_schedules_blocked_slots (clinic_id, block_start_time, block_end_time)
VALUES (2, '12:00', '12:30');

-- Clinic 3
INSERT INTO clinic_schedules_blocked_slots (clinic_id, block_start_time, block_end_time)
VALUES (3, '12:00', '13:15');


-- //////////////////////////////////////////
-- Data for booking appointment
-- //////////////////////////////////////////

INSERT INTO appointments(appointment_id, patient_id, doctor_id,
                         appointment_status, created_at, appointment_start, appointment_end, descriptions)
VALUES
    (1, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6', 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
     'IN_PROGRESS', '2026-03-16 10:00:00', '2026-03-18 09:00:00', '2026-03-18 09:30:00', 'General check-up');

INSERT INTO appointments(appointment_id, patient_id, doctor_id,
                         appointment_status, created_at, appointment_start, appointment_end, descriptions)
VALUES (2, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2', 'f2a3b4c5-d6e7-48f9-0a12-3456789bcdef',
        'IN_PROGRESS', '2026-03-16 10:05:00', '2026-03-18 10:00:00', '2026-03-18 10:20:00', 'Follow-up consultation');

INSERT INTO appointments(appointment_id, patient_id, doctor_id,
                         appointment_status, created_at, appointment_start, appointment_end, descriptions)
VALUES(3, 'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8', 'a3b4c5d6-e7f8-49a0-1b23-456789abcdef',
       'COMPLETED', '2026-03-16 10:10:00', '2026-03-17 14:00:00', '2026-03-17 14:40:00', 'Routine blood pressure check');

INSERT INTO appointments(appointment_id, patient_id, doctor_id,
                         appointment_status, created_at, appointment_start, appointment_end, descriptions)
VALUES(4, 'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9', 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'CANCELLED', '2026-03-16 10:15:00', '2026-03-19 11:00:00', '2026-03-19 11:30:00', 'Patient cancelled due to illness');

INSERT INTO appointments(appointment_id, patient_id, doctor_id,
                         appointment_status, created_at, appointment_start, appointment_end, descriptions)
VALUES (5, 'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0', 'a3b4c5d6-e7f8-49a0-1b23-456789abcdef',
        'IN_PROGRESS', '2026-03-16 10:20:00', '2026-03-20 15:00:00', '2026-03-20 15:40:00', 'Dermatology consultation');

-- //////////////////////////////////////////
-- Data for medical note
-- //////////////////////////////////////////

INSERT INTO medical_notes(note_id, appointment_id, doctor_id, patient_id, text,
                          note_create_at, last_update, note_type)
VALUES
    (1,
     1,
     'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
     'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6',
     'Patient reported mild headaches for the past three days. Blood pressure slightly elevated.',
     '2026-03-18 09:35:00',
     '2026-03-18 09:35:00',
     'CONSULTATION');

INSERT INTO medical_notes(note_id, appointment_id, doctor_id, patient_id, text,
                          note_create_at, last_update, note_type)
VALUES(2,
       2,
       'f2a3b4c5-d6e7-48f9-0a12-3456789bcdef',
       'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2',
       'Follow-up visit after flu treatment. Symptoms improving, no fever detected.',
       '2026-03-18 10:25:00',
       '2026-03-18 10:25:00',
       'FOLLOW_UP');

INSERT INTO medical_notes(note_id, appointment_id, doctor_id, patient_id, text,
                          note_create_at, last_update, note_type)
VALUES  (3,
         3,
         'a3b4c5d6-e7f8-49a0-1b23-456789abcdef',
         'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8',
         'Routine blood pressure check. Patient advised to reduce salt intake.',
         '2026-03-17 14:45:00',
         '2026-03-17 14:45:00',
         'PRESCRIPTION');

INSERT INTO medical_notes(note_id, appointment_id, doctor_id, patient_id, text,
                          note_create_at, last_update, note_type)
VALUES  (4,
         4,
         'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
         'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9',
         'Appointment cancelled by patient due to illness.',
         '2026-03-19 11:35:00',
         '2026-03-19 11:35:00',
         'FOLLOW_UP');

INSERT INTO medical_notes(note_id, appointment_id, doctor_id, patient_id, text,
                          note_create_at, last_update, note_type)
VALUES   (5,
         5,
         'a3b4c5d6-e7f8-49a0-1b23-456789abcdef',
         'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0',
         'Patient presented with mild skin irritation on forearm. Prescribed topical cream.',
         '2026-03-20 15:45:00',
         '2026-03-20 15:45:00',
         'CONSULTATION');
