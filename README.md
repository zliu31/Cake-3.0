# Cake Customization Application

An interactive web application for customizing cakes with different base flavors, frosting colors, and toppings. Built with Java Spring Boot, HTML, CSS, and JavaScript.

## Features

- **Step 1**: Choose from 3 base flavors (Matcha, Vanilla, Red Velvet)
- **Step 2**: Select from 5 frosting colors (White, Pink, Brown, Purple, Yellow)
- **Step 3**: Place an interactive strawberry topping
- **Step 4**: View your customized cake
- Smooth animations and transitions
- Responsive design
- RESTful API for order management

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Build Tool**: Maven
- **Fonts**: Leckerli One, Lemon (Google Fonts)

## Project Structure

```
cake-customization/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/cake/customization/
│       │       ├── CakeCustomizationApplication.java
│       │       ├── controller/
│       │       │   └── CakeController.java
│       │       ├── model/
│       │       │   └── CakeOrder.java
│       │       ├── service/
│       │       │   └── CakeService.java
│       │       └── config/
│       │           └── WebConfig.java
│       ├── resources/
│       │   ├── static/
│       │   │   ├── index.html
│       │   │   ├── styles.css
│       │   │   └── app.js
│       │   └── application.properties
│       └── webapp/
└── pom.xml
```

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- Modern web browser (Chrome, Firefox, Safari, Edge)

## Installation & Setup

### 1. Clone or Download the Project

```bash
git clone <repository-url>
cd cake-customization
```

### 2. Project File Organization

Ensure the following file structure:

```
project-root/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/cake/customization/
│       │       ├── CakeCustomizationApplication.java
│       │       ├── controller/
│       │       │   └── CakeController.java
│       │       ├── model/
│       │       │   └── CakeOrder.java
│       │       ├── service/
│       │       │   └── CakeService.java
│       │       └── config/
│       │           └── WebConfig.java
│       └── resources/
│           ├── application.properties
│           └── static/
│               ├── index.html
│               ├── styles.css
│               └── app.js
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the JAR file directly:

```bash
java -jar target/cake-customization-1.0.0.jar
```

### 5. Access the Application

Open your web browser and navigate to:
```
http://localhost:8080
```

## Usage

### Interactive Interface

1. **Choose Base Flavor**: Click on one of the three cake bases (Matcha, Vanilla, or Red)
2. **Select Frosting**: Choose your preferred frosting color
3. **Place Strawberry**: Drag and drop the strawberry to position it on your cake
4. **View Result**: See your completed custom cake!
5. **Start Over**: Click "Start Over" to create another cake

### API Endpoints

The application also provides RESTful API endpoints:

#### Save a Cake Order
```http
POST /api/cake/save
Content-Type: application/json

{
  "baseType": "vanilla",
  "frostingType": "pink",
  "hasStrawberry": true,
  "customerName": "John Doe",
  "customerEmail": "john@example.com"
}
```

#### Get All Orders
```http
GET /api/cake/orders
```

#### Get Order by ID
```http
GET /api/cake/order/{id}
```

#### Validate Order
```http
POST /api/cake/validate
Content-Type: application/json

{
  "baseType": "matcha",
  "frostingType": "white",
  "hasStrawberry": true
}
```

## Configuration

Edit `application.properties` to customize:

- **Server Port**: Change `server.port` (default: 8080)
- **Logging Level**: Adjust `logging.level.*` properties
- **Cache Settings**: Modify `spring.web.resources.cache.period`

## Features Breakdown

### Frontend Features

- **Responsive Design**: Works on desktop, tablet, and mobile devices
- **Smooth Animations**: CSS animations for transitions and hover effects
- **Drag & Drop**: Interactive strawberry placement in Step 3
- **Image Preloading**: Fast loading of Figma design assets
- **State Management**: JavaScript manages the customization state

### Backend Features

- **RESTful API**: Full CRUD operations for cake orders
- **Validation**: Server-side validation of cake selections
- **In-Memory Storage**: Orders stored in memory (can be extended to database)
- **Error Handling**: Comprehensive error handling and logging

## Customization Options

### Base Flavors
- Matcha (Green Tea)
- Vanilla
- Red Velvet

### Frosting Colors
- White
- Pink
- Brown (Chocolate)
- Purple (Berry)
- Yellow (Lemon)

### Toppings
- Fresh Strawberry (draggable placement)

## Development

### Hot Reload

The application uses Spring Boot DevTools for automatic restart on code changes:

1. Make changes to Java files
2. Save the file
3. Application will automatically restart

### Frontend Development

To modify the frontend:

1. Edit `index.html` for structure
2. Edit `styles.css` for styling
3. Edit `app.js` for interactivity
4. Refresh browser to see changes

### Adding New Features

To add new cake options:

1. Update `CakeService.java` to add valid options
2. Update `styles.css` to style new elements
3. Add new images to the frontend
4. Update `app.js` to handle new selections

## Testing

Run the tests:

```bash
mvn test
```

### Manual Testing Checklist

- [ ] Can select each base flavor
- [ ] Can select each frosting color
- [ ] Strawberry is draggable in Step 3
- [ ] Navigation buttons work between screens
- [ ] Final cake displays correct selections
- [ ] Start Over resets the application
- [ ] API endpoints respond correctly

## Troubleshooting

### Port Already in Use

If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Images Not Loading

Ensure you have an active internet connection to fetch images from Figma's CDN. The image URLs are valid for 7 days from generation.

### Application Won't Start

1. Check Java version: `java -version` (should be 17+)
2. Check Maven installation: `mvn -version`
3. Clean and rebuild: `mvn clean install`
4. Check logs for specific error messages

## Browser Compatibility

- Chrome 90+
- Firefox 88+
- Safari 14+
- Edge 90+

## Performance Optimization

- Images are loaded from Figma CDN
- CSS animations use GPU acceleration
- Minimal JavaScript for fast interactions
- Static resources are cached

## Future Enhancements

- [ ] Database persistence (PostgreSQL/MySQL)
- [ ] User authentication and profiles
- [ ] Additional cake sizes and shapes
- [ ] More topping options
- [ ] Order history and favorites
- [ ] Social sharing functionality
- [ ] Print/Download cake design
- [ ] Payment integration

## License

This project is provided as-is for educational and demonstration purposes.

## Support

For issues or questions:
1. Check the troubleshooting section
2. Review the code comments
3. Check Spring Boot documentation: https://spring.io/projects/spring-boot

## Credits

- Design Source: Figma
- Fonts: Google Fonts (Leckerli One, Lemon)
- Framework: Spring Boot
- Icons & Images: Figma Design Assets

---

**Enjoy customizing your cakes! 🍰**
