CREATE TABLE hospitalizations (
                                  id BIGSERIAL PRIMARY KEY,

                                  patient_id BIGINT NOT NULL,

                                  status VARCHAR(30) NOT NULL,

                                  admission_date TIMESTAMP NOT NULL,

                                  discharge_date TIMESTAMP,

                                  reason VARCHAR(255),

                                  CONSTRAINT fk_hospitalization_patient
                                      FOREIGN KEY (patient_id)
                                          REFERENCES patients(id)
);