CREATE TABLE patients (

                          id BIGSERIAL PRIMARY KEY,

                          medical_record_number VARCHAR(50),

                          full_name VARCHAR(255) NOT NULL,

                          birth_date DATE NOT NULL,

                          cpf VARCHAR(14) NOT NULL UNIQUE

);