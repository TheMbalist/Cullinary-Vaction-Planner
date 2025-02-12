export interface Experience{

    title: string;
    description: string;
    dateTime: Date;  
    price: number;  // Use 'number' for Double in TypeScript;
    restaurantRating: number;  // Use 'number' for Double
    cuisineType: string;
    restaurantId: number | null;  // Integer in Java is 'number' in TypeScript
    userID: number;  // Same as restaurantId
    venueName: string;
    venueLocation: string;
    notes: string;
    experienceID:number;
}