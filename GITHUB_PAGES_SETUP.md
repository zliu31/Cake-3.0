# GitHub Pages Setup Instructions

## ⚠️ Your site is showing blank? Follow these steps:

### Step 1: Enable GitHub Pages

1. Go to your repository: https://github.com/zliu31/Cake-3.0
2. Click on **Settings** (top right)
3. Scroll down and click **Pages** (left sidebar)
4. Under **Source**:
   - **Branch:** Select `claude/check-cake-repo-connection-01C4GYKe1SM3Dou8jpWicnzV`
   - **Folder:** Select `/ (root)`
5. Click **Save**
6. Wait 2-3 minutes for deployment

### Step 2: Check Your Site

Visit: https://zliu31.github.io/Cake-3.0/

You should now see:
- ✅ A beautiful landing page with the Cake 3.0 logo
- ✅ A "Start Designing" button
- ✅ Click it to open the cake customization app

### Step 3: If Still Blank

**Check Browser Console:**
1. Right-click on the blank page → **Inspect** → **Console** tab
2. Look for any red error messages
3. Common issues:
   - **404 errors:** GitHub Pages isn't enabled yet (do Step 1)
   - **CORS errors:** The Figma images might have expired
   - **Script errors:** Check if JavaScript is enabled

**Clear Browser Cache:**
1. Press `Ctrl+Shift+R` (Windows/Linux) or `Cmd+Shift+R` (Mac)
2. This forces a hard refresh

**Try Different Browser:**
- Test in Chrome, Firefox, or Edge
- Sometimes cache issues are browser-specific

### Alternative: Use Netlify Instead

If GitHub Pages continues to have issues, use Netlify (takes 3 minutes):

1. Go to: https://app.netlify.com/start
2. Click **"Import from Git"**
3. Select your `zliu31/Cake-3.0` repository
4. Click **"Deploy site"**
5. Your site will be at: `https://[random-name].netlify.app`

**Netlify benefits:**
- ✅ More reliable
- ✅ Faster deployment
- ✅ Better CDN
- ✅ Custom domain support
- ✅ Automatic SSL

## 🎯 Current Setup

**Files:**
- `index.html` - Landing page (always works, no external dependencies)
- `app.html` - The full cake customization application
- `test.html` - Simple test page to verify GitHub Pages is working

**Try these URLs:**
- Landing: https://zliu31.github.io/Cake-3.0/
- Test page: https://zliu31.github.io/Cake-3.0/test.html
- App directly: https://zliu31.github.io/Cake-3.0/app.html

## 🔧 Troubleshooting Specific Issues

### Issue: Images Not Loading
**Cause:** Figma CDN URLs expire after ~7 days
**Solution:** The images need to be re-exported from Figma or stored locally

### Issue: Site Works Locally But Not Online
**Cause:** GitHub Pages might not be enabled
**Solution:** Follow Step 1 above carefully

### Issue: 404 Error
**Cause:** Branch not set correctly in GitHub Pages settings
**Solution:** Make sure you selected the exact branch name (it's long!)

### Issue: Blank White Page
**Cause:** CSS/JavaScript not loading
**Solution:**
1. Check if `https://zliu31.github.io/Cake-3.0/test.html` works
2. If test.html works, the issue is with the app specifically
3. Try accessing `https://zliu31.github.io/Cake-3.0/app.html` directly

## ✅ Success Checklist

- [ ] GitHub Pages is enabled in repository settings
- [ ] Correct branch is selected
- [ ] Waited 2-3 minutes after enabling
- [ ] Cleared browser cache
- [ ] Site loads at https://zliu31.github.io/Cake-3.0/
- [ ] Landing page is visible
- [ ] Can click "Start Designing" button
- [ ] App opens and shows cake bases

## 🆘 Still Need Help?

If nothing works:
1. **Use Netlify instead** - It's more reliable for complex apps
2. **Check the DEPLOYMENT.md** file for other options
3. **Verify the repository is public** (private repos need GitHub Pro for Pages)

---

**Last Updated:** December 3, 2025
