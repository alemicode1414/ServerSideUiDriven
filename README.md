# ServerSideUiDriven

A modern Android application that demonstrates how to build dynamic user interfaces using a **Server-Driven UI (SDUI)** approach with **Jetpack Compose**. This architecture allows the UI to be updated remotely through a configurable JSON model served from the backend — enabling real-time updates without requiring app releases.

---

## ✨ Features

- 🔧 **Server-Driven UI Rendering**  
  Components are rendered based on structured data received from the backend.

- ⚙️ **Modular Architecture**  
  Clean separation of `data`, `domain`, and `presentation` layers for better maintainability.

- 🎨 **Jetpack Compose**  
  Leverages Compose for flexible and declarative UI rendering.

- 🧩 **Extensible Component Model**  
  Easily add new component types (Text, Button, Image, etc.) and rendering logic.

- 🧪 **Preview Support**  
  Includes Compose previews for rapid prototyping and visual validation.

---

## 🏗 Architecture

└── serverSideUiDriven
├── data # Data models, services, and remote layer
├── domain # Use cases and business logic
├── ui
│ ├── component # UI rendering logic per component type
│ └── screen # Composable screens
└── utils # Reusable utility functions
---
