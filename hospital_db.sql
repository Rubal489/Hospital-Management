CREATE DATABASE hospital_db;

USE hospital_db;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

-- Add some sample data
INSERT INTO patients (name, age) VALUES ('John Doe', 30);
INSERT INTO doctors (name, specialization) VALUES ('Dr. Smith', 'Cardiologist');
