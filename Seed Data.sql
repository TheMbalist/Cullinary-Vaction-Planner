
INSERT INTO Users (created_at, updated_at) VALUES
('2024-01-01', null),
('2024-01-10', null),
('2024-02-15', null),
('2024-03-21', null),
('2024-05-20', null);




INSERT INTO Users_Security(user_id, username, password, email, profile_picture) VALUES
(1, 'john_doe','password123' ,'john@example.com', 'img.jpg'),
(2, 'jane_smith','password456' ,'jane@example.com', 'img.jpg'),
(3, 'alice_jones', 'password789','alice@example.com', 'img.jpg'),
(4, 'bob_brown','password321' ,'bob@example.com', 'img.jpg'),
(5, 'charlie_black','password654' ,'charlie@example.com', 'img.jpg');


INSERT INTO Cusine_Types ( cusine_type) VALUES
('Italian'),
( 'Asian'),
('Mexican'),
('Bakery'),
('Steakhouse');


INSERT INTO Restaurants ( name, location, cuisine_type_id, rating, description, created_at, created_by, updated_at, updated_by) VALUES
('The Culinary Spot', 'New York', 1, 4.5, 'Amazing Italian cuisine in a cozy setting.', '2024-01-05', 1, null, null),
( 'Taste of Asia', 'San Francisco', 2, 4.7, 'Delicious sushi and Asian fusion dishes.', '2024-01-10', 3, null, null),
( 'Mexican Fiesta', 'Los Angeles', 3, 3.8, 'Authentic Mexican food with vibrant flavors.' , '2024-01-05', 5, null, null),
( 'Sweet Treats Bakery', 'Chicago', 4, 4.9, 'Bakery with the best pastries and cakes.', '2024-01-05', 1, null, null),
( 'Grill House', 'Miami', 5, 4.2, 'Steakhouse known for its quality meat and service.', '2024-01-05', 3, null, null);


INSERT INTO Experiences (restaurant_id, title, description, date_time, price, created_at, created_by, updated_at, updated_by) VALUES
( 1, 'Pasta Making Class', 'Learn how to make fresh pasta from scratch!', '2024-09-20 10:00:00', 50.00, '2024-01-05', 1, null, null),
( 2, 'Sushi Rolling Workshop', 'Join us for a hands-on sushi rolling experience.', '2024-09-21 14:00:00', 70.00, '2024-01-05', 3, null, null),
( 3, 'Taco Night', 'Enjoy an evening of taco making and tasting.', '2024-09-22 18:00:00', 30.00, '2024-01-05', 5, null, null),
( 4, 'Baking Cookies', 'Learn to bake delicious cookies with our chef.', '2024-09-23 16:00:00', 40.00, '2024-01-05', 1, null, null),
( 5, 'Wine and Dine', 'Experience a gourmet meal paired with fine wines.', '2024-09-24 19:00:00', 100.00, '2024-01-05', 3, null, null);


INSERT INTO Itineraries (user_id, title, description, is_public) VALUES
(2, 'Weekend in New York', 'A culinary adventure exploring New York.', 1),
(2, 'Asian Delights', 'A food tour of the best Asian restaurants.', 0),
(3, 'Taste of Mexico', 'Experience the vibrant flavors of Mexican cuisine.', 1),
(4, 'Baking Extravaganza', 'A sweet journey through Chicago’s best bakeries.', 0),
(4, 'Steak Lovers', 'An itinerary for steak enthusiasts in Miami.', 1);


INSERT INTO Itinerary_Items ( itinerary_id, experience_id, date, notes) VALUES
(1, 1, '2024-09-20', 'Make sure to wear an apron!'),
(2, 2, '2024-09-21', 'Arrive 15 minutes early.'),
(3, 3, '2024-09-22', 'Bring your appetite!'),
(4, 4, '2024-09-23', 'Don’t forget to taste the cookies!'),
(5, 5, '2024-09-24', 'Book the wine tasting in advance.');


INSERT INTO Followers ( user_id, followed_user_id) VALUES
( 1, 2),
(2, 3),
(3, 4),
(4, 5),
( 5, 1);
