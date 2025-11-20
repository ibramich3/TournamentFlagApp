# Tournament Flag App

A Java Swing-based desktop application that displays country flags for FIFA World Cup 2022 teams. Users can select a team from a dropdown menu to view the corresponding flag image.

## Overview

This application provides an interactive interface to browse and display flags of participating teams in the FIFA World Cup 2022 tournament. The application features a clean, modern GUI with a dropdown selection mechanism and dynamic flag image display.

## Features

- **Interactive Team Selection**: Dropdown menu with 6 participating teams
- **Flag Display**: High-quality flag images displayed when a team is selected
- **Modern GUI**: Clean and professional user interface with tournament branding
- **Image Scaling**: Automatic image scaling for optimal display
- **Multiple Format Support**: Supports PNG, JPG, and JPEG image formats
- **Error Handling**: Graceful handling of missing image files

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 21** or higher

**Note**: No external libraries or database connections are required. This is a standalone Java Swing application.

## Project Structure

```
TournamentFlagApp/
├── src/
│   ├── TournamentFlagApp.java    # Main application class
│   └── flags/                    # Flag images directory
│       ├── argentina.png
│       ├── brazil.png
│       ├── england.png
│       ├── france.png
│       ├── germany.png
│       ├── portugal.png
│       └── spain.png
├── bin/                          # Compiled class files
└── README.md                     # This file
```

## Flag Images

The application requires flag images to be placed in the `src/flags/` directory. The following images are included:

- `argentina.png`
- `brazil.png`
- `england.png`
- `france.png`
- `germany.png`
- `portugal.png`
- `spain.png`

**Supported Formats**: PNG, JPG, JPEG

**Naming Convention**: Images must be named in lowercase (e.g., `argentina.png`, not `Argentina.png`)

## Building and Running

### Using Eclipse IDE

1. **Import Project**:
   - File → Import → Existing Projects into Workspace
   - Select the `TournamentFlagApp` folder

2. **Verify Flag Images**:
   - Ensure all flag images are present in `src/flags/` directory
   - Images should be named in lowercase (e.g., `argentina.png`)

3. **Run the Application**:
   - Right-click on `TournamentFlagApp.java`
   - Select Run As → Java Application

### Using Command Line

1. **Compile**:
   ```bash
   javac -d bin src/TournamentFlagApp.java
   ```

2. **Run**:
   ```bash
   java -cp bin TournamentFlagApp
   ```

   **Note**: Make sure flag images are copied to `bin/flags/` directory if running from command line, or ensure the application can access `src/flags/` directory.

## Usage

1. **Launch the Application**: Run `TournamentFlagApp.java`

2. **Select a Team**:
   - Click on the dropdown menu labeled "Select Team:"
   - Choose one of the available teams:
     - Argentina
     - Brazil
     - France
     - Germany
     - Spain
     - Portugal

3. **View Flag**:
   - The corresponding flag image will automatically appear in the display area below
   - The image is automatically scaled to fit the display area

4. **Change Selection**:
   - Select a different team from the dropdown to view another flag
   - Select "Select a Team" to clear the display

## Available Teams

The application includes the following teams:

1. **Argentina** 🇦🇷
2. **Brazil** 🇧🇷
3. **France** 🇫🇷
4. **Germany** 🇩🇪
5. **Spain** 🇪🇸
6. **Portugal** 🇵🇹

## Troubleshooting

### Common Issues

1. **"Flag image not found"**:
   - Verify that flag images are in the `src/flags/` directory
   - Check that image names are in lowercase (e.g., `argentina.png`, not `Argentina.png`)
   - Ensure image file extensions are `.png`, `.jpg`, or `.jpeg`

2. **Images not displaying**:
   - Check that images are valid image files
   - Verify file permissions allow reading
   - Ensure images are not corrupted

3. **Application won't start**:
   - Verify Java 21 or higher is installed: `java -version`
   - Check that all source files are present
   - Ensure the project is properly compiled

## Adding New Teams

To add more teams to the application:

1. **Add Team Name**:
   - Edit `TournamentFlagApp.java`
   - Add the team name to the `teams` array:
   ```java
   private final String[] teams = {
       "Select a Team",
       "Argentina",
       "Brazil",
       // ... existing teams ...
       "NewTeam"  // Add here
   };
   ```

2. **Add Flag Image**:
   - Place the flag image in `src/flags/` directory
   - Name it in lowercase (e.g., `newteam.png`)

3. **Recompile and Run**:
   - Recompile the application
   - The new team will appear in the dropdown

## Technical Details

- **Language**: Java
- **GUI Framework**: Java Swing
- **Java Version**: 21
- **Image Formats Supported**: PNG, JPG, JPEG
- **Image Scaling**: Automatic scaling to 350x250 pixels

## Code Features

- **Event-Driven Architecture**: Uses ActionListener for dropdown selection
- **Resource Loading**: Multiple fallback methods for loading images (classpath, relative path, absolute path)
- **Image Processing**: Automatic image scaling with smooth rendering
- **Error Handling**: Graceful degradation when images are missing

## License

This project is provided as-is for educational purposes.

## Author

Created as part of a Java application development project.

