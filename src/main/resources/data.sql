-- Initialisation des tables
SELECT 0 as INUTILE;

INSERT INTO personne (matricule, nom, prenom, poste) VALUES (1, 'Régant', 'Jean', 'Développeur');
INSERT INTO personne (matricule, nom, prenom, poste) VALUES (2, 'Bulgarie', 'Sofia', 'Chef de projet');
INSERT INTO personne (matricule, nom, prenom, poste) VALUES (3, 'Matin', 'Martin', 'Analyste');

INSERT INTO projet (code, nom, debut, fin) VALUES (101, 'Projet X', '2024-01-01', '2024-12-31');
INSERT INTO projet (code, nom, debut, fin) VALUES (102, 'Projet Y', '2024-06-01', NULL);  -- Projet en cours sans date de fin
INSERT INTO projet (code, nom, debut, fin) VALUES (103, 'Projet Z', '2023-05-15', '2024-05-15');

INSERT INTO participation (id, contributeur_id, projet_id, role, pourcentage) VALUES (1, 1, 101, 'Développeur', 50.0);
INSERT INTO participation (id, contributeur_id, projet_id, role, pourcentage) VALUES (2, 2, 101, 'Chef de projet', 100.0);
INSERT INTO participation (id, contributeur_id, projet_id, role, pourcentage) VALUES (3, 3, 102, 'Analyste', 75.0);

UPDATE personne SET superieur_id = 2 WHERE matricule = 1;
UPDATE personne SET superieur_id = 2 WHERE matricule = 3;
