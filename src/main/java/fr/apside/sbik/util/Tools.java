package fr.apside.sbik.util;

import java.net.URI;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.h2.util.StringUtils;
import org.h2.util.Utils;

public final class Tools {


    /**
     * Open a new browser tab or window with the given URL.
     *
     * @param url the URL to open
     */
    public static void openBrowser(String url) throws Exception {
        try {
            String osName = StringUtils.toLowerEnglish(
                    Utils.getProperty("os.name", "linux"));
            Runtime rt = Runtime.getRuntime();
            String browser = null;// = Utils.getProperty(SysProperties.H2_BROWSER, null);
            //if (browser == null) {
                // under Linux, this will point to the default system browser
                try {
                    browser = System.getenv("BROWSER");
                } catch (SecurityException se) {
                    // ignore
                }
            //}
            if (browser != null) {
                if (browser.startsWith("call:")) {
                    browser = browser.substring("call:".length());
                    Utils.callStaticMethod(browser, url);
                } else if (browser.contains("%url")) {
                    String[] args = StringUtils.arraySplit(browser, ',', false);
                    for (int i = 0; i < args.length; i++) {
                        args[i] = StringUtils.replaceAll(args[i], "%url", url);
                    }
                    rt.exec(args);
                } else if (osName.contains("windows")) {
                    rt.exec(new String[] { "cmd.exe", "/C",  browser, url });
                } else {
                    rt.exec(new String[] { browser, url });
                }
                return;
            }
            try {
                Class<?> desktopClass = Class.forName("java.awt.Desktop");
                // Desktop.isDesktopSupported()
                Boolean supported = (Boolean) desktopClass.
                    getMethod("isDesktopSupported").
                    invoke(null, new Object[0]);
                URI uri = new URI(url);
                if (supported) {
                    // Desktop.getDesktop();
                    Object desktop = desktopClass.getMethod("getDesktop").
                        invoke(null, new Object[0]);
                    // desktop.browse(uri);
                    desktopClass.getMethod("browse", URI.class).
                        invoke(desktop, uri);
                    return;
                }
            } catch (Exception e) {
                // ignore
            }
            if (osName.contains("windows")) {
                rt.exec(new String[] { "rundll32", "url.dll,FileProtocolHandler", url });
            } else if (osName.contains("mac") || osName.contains("darwin")) {
                // Mac OS: to open a page with Safari, use "open -a Safari"
                Runtime.getRuntime().exec(new String[] { "open", url });
            } else {
                String[] browsers = { "chromium", "google-chrome", "firefox",
                        "mozilla-firefox", "mozilla", "konqueror", "netscape",
                        "opera", "midori" };
                boolean ok = false;
                for (String b : browsers) {
                    try {
                        rt.exec(new String[] { b, url });
                        ok = true;
                        break;
                    } catch (Exception e) {
                        // ignore and try the next
                    }
                }
                if (!ok) {
                    // No success in detection.
                    throw new Exception(
                            "Browser detection failed and system property not set");
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "Failed to start a browser to open the URL " +
            url + ": " + e.getMessage());
        }
    }
    
    /**
     * 
     */
    public static <T> void setNavigationParam(String paramName, T paramValue){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put(paramName, paramValue);
	}
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
	public static <T> T getNavigationParam(String paramName){
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getExternalContext().getSessionMap().get(paramName);
	}
    
    /**
     * 
     */
    public static String getUrlRedirectPage(String urlPage){
    	return urlPage + "?faces-redirect=true";
    }

	/**
     * 
     */
	public static void addErrorMessage(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
	}

	/**
     * 
     */
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
	}

	/**
     * 
     */
	public static void addSuccessMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", message));
	}

	/**
     * 
     */
	public static void addInfoMessage(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
	}
}

