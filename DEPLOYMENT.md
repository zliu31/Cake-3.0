# Deployment Guide - Cake 3.0 Website

This guide provides multiple options for deploying your Cake Customization website publicly.

## Quick Start: Static Website Deployment (Recommended for Demo)

The simplest way to make your website public is to deploy the frontend as a static website.

### Option 1: GitHub Pages (FREE)

**Steps:**

1. **Ensure your code is pushed to GitHub** (Already done ✓)

2. **Enable GitHub Pages:**
   - Go to your repository on GitHub: `https://github.com/zliu31/Cake-3.0`
   - Click on **Settings**
   - Scroll down to **Pages** in the left sidebar
   - Under **Source**, select the branch: `claude/check-cake-repo-connection-01C4GYKe1SM3Dou8jpWicnzV`
   - Select folder: **/ (root)**
   - Click **Save**

3. **Access your website:**
   - Your site will be available at: `https://zliu31.github.io/Cake-3.0/`
   - It may take 1-2 minutes for the site to become available

**Note:** The static version includes HTML, CSS, and JavaScript but not the Java backend API.

---

### Option 2: Netlify (FREE with more features)

**Steps:**

1. Go to [Netlify](https://www.netlify.com/)
2. Sign up with your GitHub account
3. Click **"Add new site"** → **"Import an existing project"**
4. Connect to GitHub and select `zliu31/Cake-3.0` repository
5. Configure build settings:
   - **Build command:** Leave empty (static site)
   - **Publish directory:** `/` (root directory)
6. Click **Deploy**

Your site will be live at: `https://[random-name].netlify.app`
You can customize the subdomain in Netlify settings.

**Advantages:**
- Custom domain support
- Automatic HTTPS
- Continuous deployment (auto-updates on push)
- Better performance with CDN

---

### Option 3: Vercel (FREE)

**Steps:**

1. Go to [Vercel](https://vercel.com/)
2. Sign up with your GitHub account
3. Click **"Add New Project"**
4. Import `zliu31/Cake-3.0` repository
5. Configure:
   - **Framework Preset:** Other
   - **Root Directory:** `./`
6. Click **Deploy**

Your site will be live at: `https://[project-name].vercel.app`

---

## Full Application Deployment (Spring Boot + Frontend)

If you want to deploy the complete application with backend API support:

### Option 4: Railway (FREE tier available)

**Steps:**

1. Go to [Railway](https://railway.app/)
2. Sign up with your GitHub account
3. Click **"New Project"** → **"Deploy from GitHub repo"**
4. Select `zliu31/Cake-3.0`
5. Railway will auto-detect Spring Boot
6. Add environment variables if needed:
   ```
   SPRING_PROFILES_ACTIVE=prod
   SERVER_PORT=8080
   ```
7. Deploy!

Your app will be live at: `https://[project-name].up.railway.app`

---

### Option 5: Render (FREE tier available)

**Steps:**

1. Go to [Render](https://render.com/)
2. Sign up with your GitHub account
3. Click **"New +"** → **"Web Service"**
4. Connect `zliu31/Cake-3.0` repository
5. Configure:
   - **Name:** cake-customization
   - **Environment:** Java
   - **Build Command:** `mvn clean install`
   - **Start Command:** `java -jar target/cake-customization-1.0.0.jar`
6. Click **Create Web Service**

Your app will be live at: `https://cake-customization.onrender.com`

---

### Option 6: Heroku

**Steps:**

1. Install [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
2. Login to Heroku:
   ```bash
   heroku login
   ```
3. Create a new app:
   ```bash
   heroku create cake-customization-app
   ```
4. Add Java buildpack:
   ```bash
   heroku buildpacks:set heroku/java
   ```
5. Deploy:
   ```bash
   git push heroku claude/check-cake-repo-connection-01C4GYKe1SM3Dou8jpWicnzV:main
   ```

Your app will be live at: `https://cake-customization-app.herokuapp.com`

---

## Docker Deployment

If you prefer containerization, use the provided Dockerfile:

**Steps:**

1. Build the Docker image:
   ```bash
   docker build -t cake-customization .
   ```

2. Run the container:
   ```bash
   docker run -p 8080:8080 cake-customization
   ```

3. Deploy to any cloud platform that supports Docker:
   - **Google Cloud Run**
   - **AWS ECS**
   - **Azure Container Instances**
   - **DigitalOcean App Platform**

---

## Recommendation by Use Case

| Use Case | Recommended Platform | Reason |
|----------|---------------------|---------|
| Quick demo/portfolio | **GitHub Pages** or **Netlify** | Free, fast, no backend needed |
| Full app with API | **Railway** or **Render** | Free tier, easy setup, supports Spring Boot |
| Production app | **AWS**, **GCP**, or **Azure** | Scalability, reliability, custom domain |
| Learning/testing | **Vercel** or **Netlify** | Great developer experience |

---

## Production Checklist

Before deploying to production:

- [ ] Update `application.properties` with production settings
- [ ] Set up proper database (if needed)
- [ ] Configure environment variables
- [ ] Enable HTTPS
- [ ] Set up custom domain
- [ ] Configure CORS settings
- [ ] Add error tracking (e.g., Sentry)
- [ ] Set up monitoring (e.g., New Relic, Datadog)
- [ ] Configure caching
- [ ] Add rate limiting
- [ ] Set up CI/CD pipeline

---

## Custom Domain Setup

Once deployed, you can connect a custom domain:

### For GitHub Pages:
1. Go to repository **Settings** → **Pages**
2. Add your custom domain
3. Update DNS records with your domain provider

### For Netlify/Vercel:
1. Go to **Domain settings**
2. Add your custom domain
3. Follow DNS configuration instructions

---

## Security Considerations

**For Production Deployment:**

1. **Environment Variables:** Never commit sensitive data
   ```bash
   export DB_PASSWORD=your_secure_password
   export API_KEY=your_api_key
   ```

2. **CORS Configuration:** Update `WebConfig.java` with your production domain:
   ```java
   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/api/**")
           .allowedOrigins("https://yourdomain.com")
           .allowedMethods("GET", "POST", "PUT", "DELETE");
   }
   ```

3. **HTTPS:** Always use HTTPS in production (most platforms provide this automatically)

---

## Troubleshooting

### Images Not Loading
- Figma asset URLs expire after 7 days
- Solution: Download images and host them locally or use a permanent CDN

### Port Issues
- Most cloud platforms assign ports automatically
- Use `${PORT}` environment variable in production

### Build Failures
- Ensure Java 17 is specified in platform settings
- Check Maven build logs for errors

---

## Support

For deployment issues:
- Check platform-specific documentation
- Review deployment logs
- Ensure all dependencies are included in `pom.xml`

---

**Ready to deploy? Choose an option above and follow the steps!** 🚀
