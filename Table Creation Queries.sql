


CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME NULL,

);

CREATE TABLE Users_Security(
	user_security_id  INT PRIMARY KEY IDENTITY(1,1),
	user_id INT FOREIGN KEY REFERENCES Users(user_id), 
	username NVARCHAR(100) NOT NULL,
    password NVARCHAR(100) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    profile_picture NVARCHAR(255),
);


CREATE TABLE Itineraries (
    itinerary_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT FOREIGN KEY REFERENCES Users(user_id),
    title NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX),
    is_public BIT DEFAULT 0,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME NULL
);

CREATE TABLE Cusine_Types(
cusine_type_id INT PRIMARY KEY IDENTITY(1,1),
cusine_type NVARCHAR(100) NOT NULL,


);

CREATE TABLE Restaurants (
    restaurant_id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    location NVARCHAR(255),
    cuisine_type_id INT FOREIGN KEY REFERENCES Cusine_Types(cusine_type_id),
    rating FLOAT CHECK (rating >= 0 AND rating <= 5),
    description NVARCHAR(MAX),
    created_at DATETIME DEFAULT GETDATE(),
	created_by INT FOREIGN KEY REFERENCES Users(user_id),
	updated_at DATETIME NULL,
	updated_by INT FOREIGN KEY REFERENCES Users(user_id) NULL


);


CREATE TABLE Experiences (
    experience_id INT PRIMARY KEY IDENTITY(1,1),
    restaurant_id INT FOREIGN KEY REFERENCES Restaurants(restaurant_id),
    title NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX),
    date_time DATETIME NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
	created_by INT FOREIGN KEY REFERENCES Users(user_id),
	updated_at DATETIME NULL,
	updated_by INT FOREIGN KEY REFERENCES Users(user_id) NULL
);

CREATE TABLE Itinerary_Items (
    itinerary_item_id INT PRIMARY KEY IDENTITY(1,1),
    itinerary_id INT FOREIGN KEY REFERENCES Itineraries(itinerary_id),
    experience_id INT FOREIGN KEY REFERENCES Experiences(experience_id),
    date DATE NOT NULL,
    notes NVARCHAR(MAX)
);

CREATE TABLE Followers (
    follower_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT FOREIGN KEY REFERENCES Users(user_id),
    followed_user_id INT FOREIGN KEY REFERENCES Users(user_id)
);
