// Application State
const appState = {
    currentScreen: 1,
    selectedBase: null,
    selectedFrosting: null,
    strawberryPlaced: false
};

// Image URLs for final cake composition
const imageUrls = {
    base: {
        matcha: 'https://www.figma.com/api/mcp/asset/f229291e-9a84-4f0e-9ad1-552e5820b78c',
        vanilla: 'https://www.figma.com/api/mcp/asset/73586ded-d9d8-434e-a216-5ac98450f012',
        red: 'https://www.figma.com/api/mcp/asset/64eaa625-a97b-4515-b28d-9b493057049e'
    },
    frosting: {
        white: 'https://www.figma.com/api/mcp/asset/72393f20-5534-401e-8e61-e7b46a73e2e2',
        pink: 'https://www.figma.com/api/mcp/asset/748e3467-1728-4cc1-b6b0-879417843375',
        brown: 'https://www.figma.com/api/mcp/asset/8df9f123-6ed6-4e7f-8d44-f648956332d9',
        purple: 'https://www.figma.com/api/mcp/asset/0ed839de-9388-4960-8cfa-69e6da22f69f',
        yellow: 'https://www.figma.com/api/mcp/asset/ba283fc0-4cc4-4187-bbc5-8a852db282fe'
    },
    strawberry: 'https://www.figma.com/api/mcp/asset/60c52e39-874f-48df-abaa-4af3aa446d2a'
};

// Initialize app
document.addEventListener('DOMContentLoaded', function() {
    initializeApp();
    setupStrawberryDrag();
});

function initializeApp() {
    console.log('Cake Customization App Initialized');
    showScreen(1);
}

// Screen Navigation
function showScreen(screenNumber) {
    // Hide all screens
    const screens = document.querySelectorAll('.screen');
    screens.forEach(screen => {
        screen.classList.remove('active');
    });
    
    // Show target screen
    const targetScreen = document.querySelector(`[data-screen="${screenNumber}"]`);
    if (targetScreen) {
        targetScreen.classList.add('active');
        targetScreen.classList.add('fade-in');
        appState.currentScreen = screenNumber;
        
        // If showing final screen, render the cake
        if (screenNumber === 4) {
            renderFinalCake();
        }
    }
}

function nextScreen(nextScreenNumber) {
    // Validation
    if (appState.currentScreen === 1 && !appState.selectedBase) {
        alert('Please select a base flavor first!');
        return;
    }
    
    if (appState.currentScreen === 2 && !appState.selectedFrosting) {
        alert('Please select a frosting color first!');
        return;
    }
    
    showScreen(nextScreenNumber);
}

// Base Selection
function selectBase(baseType) {
    appState.selectedBase = baseType;
    
    // Update UI - highlight selected base
    const baseItems = document.querySelectorAll('.base-item');
    baseItems.forEach(item => {
        item.classList.remove('selected');
    });
    
    const selectedItem = document.querySelector(`[data-base="${baseType}"]`);
    if (selectedItem) {
        selectedItem.classList.add('selected');
    }
    
    console.log('Selected base:', baseType);
}

// Frosting Selection
function selectFrosting(frostingType) {
    appState.selectedFrosting = frostingType;
    
    // Update UI - highlight selected frosting
    const frostingItems = document.querySelectorAll('.frosting-item');
    frostingItems.forEach(item => {
        item.classList.remove('selected');
    });
    
    const selectedItem = document.querySelector(`[data-frosting="${frostingType}"]`);
    if (selectedItem) {
        selectedItem.classList.add('selected');
    }
    
    console.log('Selected frosting:', frostingType);
}

// Strawberry Drag and Drop
function setupStrawberryDrag() {
    const strawberry = document.getElementById('strawberry');
    if (!strawberry) return;
    
    let isDragging = false;
    let currentX;
    let currentY;
    let initialX;
    let initialY;
    let xOffset = 0;
    let yOffset = 0;
    
    strawberry.addEventListener('mousedown', dragStart);
    strawberry.addEventListener('touchstart', dragStart);
    
    document.addEventListener('mousemove', drag);
    document.addEventListener('touchmove', drag);
    
    document.addEventListener('mouseup', dragEnd);
    document.addEventListener('touchend', dragEnd);
    
    function dragStart(e) {
        if (e.type === 'touchstart') {
            initialX = e.touches[0].clientX - xOffset;
            initialY = e.touches[0].clientY - yOffset;
        } else {
            initialX = e.clientX - xOffset;
            initialY = e.clientY - yOffset;
        }
        
        if (e.target === strawberry) {
            isDragging = true;
        }
    }
    
    function drag(e) {
        if (isDragging) {
            e.preventDefault();
            
            if (e.type === 'touchmove') {
                currentX = e.touches[0].clientX - initialX;
                currentY = e.touches[0].clientY - initialY;
            } else {
                currentX = e.clientX - initialX;
                currentY = e.clientY - initialY;
            }
            
            xOffset = currentX;
            yOffset = currentY;
            
            setTranslate(currentX, currentY, strawberry);
            appState.strawberryPlaced = true;
        }
    }
    
    function dragEnd(e) {
        initialX = currentX;
        initialY = currentY;
        isDragging = false;
    }
    
    function setTranslate(xPos, yPos, el) {
        el.style.transform = `translate(${xPos}px, ${yPos}px) rotate(334deg)`;
    }
}

// Render Final Cake
function renderFinalCake() {
    const finalCakeContainer = document.getElementById('finalCake');
    if (!finalCakeContainer) return;
    
    // Clear previous content
    finalCakeContainer.innerHTML = '';
    
    // Create cake elements
    if (appState.selectedBase) {
        const baseImg = document.createElement('img');
        baseImg.src = imageUrls.base[appState.selectedBase];
        baseImg.className = 'final-cake-base';
        baseImg.alt = `${appState.selectedBase} base`;
        finalCakeContainer.appendChild(baseImg);
    }
    
    if (appState.selectedFrosting) {
        const frostingImg = document.createElement('img');
        frostingImg.src = imageUrls.frosting[appState.selectedFrosting];
        frostingImg.className = 'final-cake-frosting';
        frostingImg.alt = `${appState.selectedFrosting} frosting`;
        finalCakeContainer.appendChild(frostingImg);
    }
    
    // Always add strawberry on final screen
    const strawberryImg = document.createElement('img');
    strawberryImg.src = imageUrls.strawberry;
    strawberryImg.className = 'final-cake-strawberry';
    strawberryImg.alt = 'strawberry topping';
    finalCakeContainer.appendChild(strawberryImg);
    
    console.log('Final cake rendered with:', appState);
}

// Restart Application
function restartApp() {
    // Reset state
    appState.currentScreen = 1;
    appState.selectedBase = null;
    appState.selectedFrosting = null;
    appState.strawberryPlaced = false;
    
    // Reset strawberry position
    const strawberry = document.getElementById('strawberry');
    if (strawberry) {
        strawberry.style.transform = 'translate(-50%, -50%) rotate(334deg)';
    }
    
    // Clear selections
    document.querySelectorAll('.base-item, .frosting-item').forEach(item => {
        item.classList.remove('selected');
    });
    
    // Go back to first screen
    showScreen(1);
    
    console.log('App restarted');
}

// Export state for Java integration (if needed)
function getAppState() {
    return JSON.stringify(appState);
}

function setAppState(stateJson) {
    const newState = JSON.parse(stateJson);
    Object.assign(appState, newState);
}

// Debug helper
function debugState() {
    console.log('Current App State:', appState);
}
