# Exact Figma Position Reference Guide

This document shows the EXACT pixel coordinates from your Figma design file for all elements.

## Screen Dimensions
- **Width**: 1512px
- **Height**: 863px

---

## Screen 1: Choose Base Flavor (Frame 1:2)

### Title
- **Position**: x=31px, y=41px
- **Size**: 1449px × 252px
- **Font**: Leckerli One, 100px
- **Color**: White
- **Text**: "Step 1: Choose Your Base Flavor"

### Matcha Base
- **Position**: x=-12px, y=307px
- **Size**: 529px × 495px
- **Image**: Matcha cake base

### Vanilla Base
- **Position**: x=517px, y=279px
- **Size**: 478px × 477px
- **Image**: Vanilla cake base

### Red Base
- **Position**: x=995px, y=321px
- **Size**: 538px × 506px
- **Image**: Red velvet cake base

### Next Button
- **Position**: x=624px, y=742px
- **Size**: 264px × 90px
- **Border Radius**: 45px
- **Background**: White
- **Text Color**: #ff5f9f
- **Font**: Lemon, 45px

---

## Screen 2: Choose Frosting Color (Frame 3:4)

### Title
- **Position**: x=42px, y=38px
- **Size**: 1449px × 252px
- **Font**: Leckerli One, 100px
- **Color**: White
- **Text**: "Step 2: Choose Frosting Color"

### White Frosting
- **Position**: x=-20px, y=156px
- **Size**: 461px × 484px
- **Image**: White frosting

### Pink Frosting
- **Position**: x=448px, y=219px
- **Size**: 229px × 438px
- **Image**: Pink frosting

### Brown Frosting
- **Position**: x=638px, y=253px
- **Size**: 308px × 431px
- **Image**: Brown/chocolate frosting

### Purple Frosting
- **Position**: x=830px, y=290px
- **Size**: 379px × 437px
- **Image**: Purple frosting

### Yellow Frosting
- **Position**: x=1020px, y=352px
- **Size**: 471px × 413px
- **Image**: Yellow/lemon frosting

### Next Button
- **Position**: x=624px, y=742px
- **Size**: 264px × 90px
- **Border Radius**: 45px
- **Background**: White
- **Text Color**: #ff5f9f
- **Font**: Lemon, 45px

---

## Screen 3: Place Strawberry (Frame 5:19)

### Title
- **Position**: x=31px, y=470px
- **Size**: 1449px × 252px
- **Font**: Leckerli One, 100px
- **Color**: White
- **Text**: "Step 3: Place Your Strawberry On Top!"

### Hand Cursor
- **Position**: x=960px, y=-4px
- **Size**: 444.999px × 290.528px
- **Image**: Hand cursor graphic
- **Z-Index**: 10

### Strawberry (Draggable)
- **Initial Position**: x=888px, y=224.804px
- **Size**: 257.056px × 257.056px
- **Rotation**: 334.186°
- **Image**: Strawberry
- **Z-Index**: 20
- **Cursor**: grab/grabbing

### Next Button
- **Position**: x=639px, y=742px
- **Size**: 264px × 90px
- **Border Radius**: 45px
- **Background**: White
- **Text Color**: #ff5f9f
- **Font**: Lemon, 45px

---

## Screen 4: Final Result (Frame 7:29)

### Title
- **Position**: x=46px, y=699px
- **Size**: 1449px × 252px
- **Font**: Leckerli One, 100px
- **Color**: White
- **Text**: "Your Cake is Ready!"

### Cake Display Container
- **Position**: x=435px, y=47px
- **Size**: 671px × 651px
- **Background**: White
- **Content**: Stacked cake layers (base + frosting + strawberry)

### Next Button (Start Over)
- **Position**: x=624px, y=742px
- **Size**: 264px × 90px
- **Border Radius**: 45px
- **Background**: White
- **Text Color**: #ff5f9f
- **Font**: Lemon, 45px

---

## CSS Implementation Notes

### Absolute Positioning
All elements use `position: absolute` with exact pixel values:
```css
.element {
    position: absolute;
    left: [X]px;
    top: [Y]px;
    width: [W]px;
    height: [H]px;
}
```

### Screen Container
```css
.screen {
    position: fixed;
    top: 0;
    left: 0;
    width: 1512px;
    height: 863px;
}
```

### Transform Handling
The strawberry rotation is applied via CSS transform:
```css
.strawberry {
    transform: rotate(334.186deg);
}
```

---

## Responsive Scaling

For screens smaller than 1512px, the entire screen is scaled proportionally:

```css
@media (max-width: 1512px) {
    .screen {
        transform: scale(0.8);
        transform-origin: top left;
    }
}
```

This maintains all exact proportions and positions.

---

## Verification Checklist

Use this checklist to verify all positions match Figma:

### Screen 1
- [ ] Matcha base at x=-12, y=307
- [ ] Vanilla base at x=517, y=279
- [ ] Red base at x=995, y=321
- [ ] Title at x=31, y=41
- [ ] Button at x=624, y=742

### Screen 2
- [ ] White frosting at x=-20, y=156
- [ ] Pink frosting at x=448, y=219
- [ ] Brown frosting at x=638, y=253
- [ ] Purple frosting at x=830, y=290
- [ ] Yellow frosting at x=1020, y=352
- [ ] Title at x=42, y=38
- [ ] Button at x=624, y=742

### Screen 3
- [ ] Hand at x=960, y=-4
- [ ] Strawberry at x=888, y=224.8
- [ ] Title at x=31, y=470
- [ ] Button at x=639, y=742

### Screen 4
- [ ] Cake display at x=435, y=47
- [ ] Title at x=46, y=699
- [ ] Button at x=624, y=742

---

## File Reference

### Updated Files with Exact Positions
1. **index-fixed.html** - HTML with exact structure
2. **styles-fixed.css** - CSS with exact pixel coordinates
3. **app-fixed.js** - JavaScript with position tracking

### Original Files (Flexible Layout)
1. **index.html** - Responsive layout version
2. **styles.css** - Flexible positioning version
3. **app.js** - Original JavaScript

---

## Developer Notes

### Why Exact Positioning?
- Matches Figma design pixel-perfect
- Maintains exact visual hierarchy
- Preserves designer's intent
- Easier to verify against design mockups

### Tradeoffs
- **Pros**: Pixel-perfect accuracy
- **Cons**: Fixed viewport size, requires scaling for responsive

### Best Use Cases
- High-fidelity prototypes
- Design reviews
- Client presentations
- Desktop applications with fixed canvas

---

**Use the fixed files (index-fixed.html, styles-fixed.css, app-fixed.js) for exact Figma positioning!**
