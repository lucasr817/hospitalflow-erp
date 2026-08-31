CREATE TABLE triages (
                         id BIGSERIAL PRIMARY KEY,

                         attendance_record_id BIGINT NOT NULL,

                         main_complaint VARCHAR(500) NOT NULL,
                         symptom_history VARCHAR(1000),
                         pain_intensity INTEGER,
                         pain_radiation VARCHAR(500),

                         medical_history VARCHAR(1000),
                         continuous_medications VARCHAR(1000),
                         allergies VARCHAR(1000),
                         recent_context VARCHAR(1000),

                         heart_rate INTEGER,
                         blood_pressure VARCHAR(20),
                         respiratory_rate INTEGER,
                         oxygen_saturation INTEGER,
                         temperature DOUBLE PRECISION,
                         capillary_blood_glucose INTEGER,

                         consciousness_level VARCHAR(100),
                         general_appearance VARCHAR(500),

                         risk_classification VARCHAR(30) NOT NULL,

                         created_at TIMESTAMP NOT NULL,

                         CONSTRAINT fk_triage_attendance
                             FOREIGN KEY (attendance_record_id)
                                 REFERENCES attendance_records(id),

                         CONSTRAINT uk_triage_attendance
                             UNIQUE (attendance_record_id)
);