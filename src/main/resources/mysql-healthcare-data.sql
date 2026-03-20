-- //////////////////////////////////////////
-- Data for patients
-- //////////////////////////////////////////

INSERT INTO patients(
    id, patient_id, full_name, date_of_birth, gender,
    contact_email, contact_phone,
    street, city, province, postal_code, country,
    insurancenumber, allergy_substance, allergy_reaction,
    blood_type, patient_status
) VALUES
      (1, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6', 'John Smith', '1985-03-15', 'M',
       'john.smith@example.com', '514-555-0101',
       '123 Maple St', 'Montreal', 'Quebec', 'H1A1A1', 'Canada',
       'INS-1001', 'Peanuts', 'Anaphylaxis',
       'AB', 'ACTIVE'),

      (2, 'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2', 'Emily Johnson', '1990-07-22', 'F',
       'emily.johnson@example.com', '514-555-0102',
       '456 Oak St', 'Laval', 'Quebec', 'H7B2B2', 'Canada',
       'INS-1002', 'None', 'None',
       'A', 'ACTIVE'),

      (3, 'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8', 'Michael Brown', '1978-11-05', 'M',
       'michael.brown@example.com', '514-555-0103',
       '789 Pine St', 'Toronto', 'Ontario', 'M5C1C1', 'Canada',
       'INS-1003', 'Gluten', 'Anaphylaxis',
       'B', 'ACTIVE'),

      (4, 'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9', 'Sarah Davis', '1995-01-18', 'F',
       'sarah.davis@example.com', '514-555-0104',
       '321 Birch St', 'Montreal', 'Quebec', 'H2D3D3', 'Canada',
       'INS-1004', 'Penicillin', 'Anaphylaxis',
       'O', 'ACTIVE'),

      (5, 'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0', 'David Lee', '1982-05-30', 'M',
       'david.lee@example.com', '514-555-0105',
       '654 Cedar St', 'Toronto', 'Ontario', 'M4E2E2', 'Canada',
       'INS-1005', 'None', 'None',
       'A', 'ACTIVE');


-- //////////////////////////////////////////
-- Data for doctors
-- Only one doctor for the clinic
-- //////////////////////////////////////////

INSERT INTO doctors(
    id, doctor_id, first_name, last_name, is_active, is_valid,
    work_zone_city, work_zone_province
) VALUES
    (1, 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 'John', 'Smith', TRUE, TRUE, 'Montreal', 'Quebec');

INSERT INTO doctor_specialities(
    doctor_id, speciality_name, proficiency_level
) VALUES
    ('e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 'General Practice', 3);

INSERT INTO doctor_license(
    license_id, license_name, doctor_id, status, performed_date, expiry_date
) VALUES
    (24001, 'General Practice License', 'e1f2a3b4-c5d6-47e8-9f01-23456789abcd', 0, '2022-01-15 00:00:00', '2027-01-15 00:00:00');


-- //////////////////////////////////////////
-- Data for clinic rooms
-- Replaces old clinic_schedules data
-- //////////////////////////////////////////

INSERT INTO clinic_rooms(
    id, room_id, room_name, room_number, room_status
) VALUES
      (1, 'r1a2b3c4-d5e6-47f8-9a10-111111111111', 'Consultation Room A', '101', 'AVAILABLE'),
      (2, 'r2a2b3c4-d5e6-47f8-9a10-222222222222', 'Consultation Room B', '102', 'AVAILABLE'),
      (3, 'r3a2b3c4-d5e6-47f8-9a10-333333333333', 'Treatment Room', '201', 'OUT_OF_SERVICE');


-- //////////////////////////////////////////
-- Data for booking appointment
-- Double-booking is now checked on room_id + overlapping time
-- //////////////////////////////////////////

INSERT INTO appointments(
    appointment_id,
    patient_id,
    doctor_id,
    room_id,
    appointment_status,
    created_at,
    appointment_start,
    appointment_end,
    descriptions
) VALUES
      (1,
       'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'r1a2b3c4-d5e6-47f8-9a10-111111111111',
       'CONFIRMED',
       '2026-03-16 10:00:00',
       '2026-03-18 09:00:00',
       '2026-03-18 09:30:00',
       'General check-up'),

      (2,
       'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'r2a2b3c4-d5e6-47f8-9a10-222222222222',
       'CONFIRMED',
       '2026-03-16 10:05:00',
       '2026-03-18 10:00:00',
       '2026-03-18 10:30:00',
       'Follow-up consultation'),

      (3,
       'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'r1a2b3c4-d5e6-47f8-9a10-111111111111',
       'COMPLETED',
       '2026-03-16 10:10:00',
       '2026-03-17 14:00:00',
       '2026-03-17 14:30:00',
       'Routine blood pressure check'),

      (4,
       'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'r2a2b3c4-d5e6-47f8-9a10-222222222222',
       'CANCELLED',
       '2026-03-16 10:15:00',
       '2026-03-19 11:00:00',
       '2026-03-19 11:30:00',
       'Patient cancelled due to illness'),

      (5,
       'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'r1a2b3c4-d5e6-47f8-9a10-111111111111',
       'CONFIRMED',
       '2026-03-16 10:20:00',
       '2026-03-20 15:00:00',
       '2026-03-20 15:30:00',
       'Skin irritation consultation');


-- //////////////////////////////////////////
-- Data for medical note
-- Keep this only if your MedicalNote mapping starts cleanly
-- //////////////////////////////////////////

INSERT INTO medical_notes(
    note_id, appointment_id, doctor_id, patient_id, text,
    note_create_at, last_update, note_type
) VALUES
      (1, 1,
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6',
       'Patient reported mild headaches for the past three days. Blood pressure slightly elevated.',
       '2026-03-18 09:35:00',
       '2026-03-18 09:35:00',
       'CONSULTATION'),

      (2, 2,
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'c1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b9a2',
       'Follow-up visit after flu treatment. Symptoms improving, no fever detected.',
       '2026-03-18 10:35:00',
       '2026-03-18 10:35:00',
       'FOLLOW_UP'),

      (3, 3,
       'e3f4a5b6-c7d8-e9f0-a1b2-c3d4e5f6a7b8',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'Routine blood pressure check. Patient advised to reduce salt intake.',
       '2026-03-17 14:35:00',
       '2026-03-17 14:35:00',
       'PRESCRIPTION'),

      (4, 4,
       'f4a5b6c7-d8e9-f0a1-b2c3-d4e5f6a7b8c9',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'Appointment cancelled by patient due to illness.',
       '2026-03-19 11:35:00',
       '2026-03-19 11:35:00',
       'FOLLOW_UP'),

      (5, 5,
       'a5b6c7d8-e9f0-a1b2-c3d4-e5f6a7b8c9d0',
       'e1f2a3b4-c5d6-47e8-9f01-23456789abcd',
       'Patient presented with mild skin irritation on forearm. Prescribed topical cream.',
       '2026-03-20 15:35:00',
       '2026-03-20 15:35:00',
       'CONSULTATION');