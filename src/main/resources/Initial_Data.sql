INSERT INTO age (age) VALUES ('antique');
INSERT INTO age (age) VALUES ('classic');
INSERT INTO age (age) VALUES ('retro');
INSERT INTO age (age) VALUES ('contemporary');
INSERT INTO age (age) VALUES ('paleolithic');
INSERT INTO category (category) VALUES ('arrowhead');
INSERT INTO category (category) VALUES ('coins');
INSERT INTO category (category) VALUES ('cards');
INSERT INTO category (category) VALUES ('stamps');
INSERT INTO category (category) VALUES ('ornaments');
INSERT INTO category (category) VALUES ('books');
INSERT INTO color (color) VALUES ('blue');
INSERT INTO color (color) VALUES ('red');
INSERT INTO color (color) VALUES ('green');
INSERT INTO color (color) VALUES ('yellow');
INSERT INTO color (color) VALUES ('purple');
INSERT INTO color (color) VALUES ('orange');
INSERT INTO condition (condition) VALUES ('new');
INSERT INTO condition (condition) VALUES ('mint');
INSERT INTO condition (condition) VALUES ('used');
INSERT INTO condition (condition) VALUES ('fair');
INSERT INTO condition (condition) VALUES ('poor');
INSERT INTO condition (condition) VALUES ('tea-stained');
INSERT INTO keyword (keyword) VALUES ('shiny');
INSERT INTO keyword (keyword) VALUES ('large');
INSERT INTO keyword (keyword) VALUES ('fancy');
INSERT INTO keyword (keyword) VALUES ('expensive');
INSERT INTO keyword (keyword) VALUES ('counterfeit');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('AAA-123456789101', 'swiss nuclear', 'clock', TRUE, 1, 1, 1);
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('BBB-123456789101', 'so comfortable', 'chair', FALSE, 2, 2, 2);
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('CCC-123456789101', 'extremely plastic', 'cup', FALSE, 3, 3, 3);
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('DDD-123456789101', 'lava', 'lamp', TRUE, 4, 4, 4, 4);
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('EEE-123456789101', 'the first magazine i ever read', 'magazine', TRUE, 5, 5, 5);
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id) VALUES ('FFF-123456789101', 'a diamond encrusted pen', 'pen', TRUE, 1, 6, 2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,1);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,4);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,1);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,1);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,1);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (2,1);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (2,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,6);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (5,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,6);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,5);


