CREATE TABLE attendance_records (
                                    id BIGSERIAL PRIMARY KEY,

                                    patient_id BIGINT NOT NULL,

                                    created_at TIMESTAMP NOT NULL,

                                    attendance_type VARCHAR(30) NOT NULL,

                                    status VARCHAR(30) NOT NULL,

                                    CONSTRAINT fk_attendance_patient
                                        FOREIGN KEY (patient_id)
                                            REFERENCES patients(id)
);