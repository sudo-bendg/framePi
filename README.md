# framePi

**framePi** is a lightweight, Raspberry Pi-powered digital photo frame. It displays a fullscreen slideshow of images on a connected display and will provide a locally hosted web interface for uploading images and changing settings.

---

## 📦 Features

- Fullscreen photo slideshow using `feh`
- Randomized image display with configurable delay
- Runs on Raspberry Pi OS Lite with minimal resource usage
- Prevents screen blanking and power-saving interruptions
- Local web interface for:
  - Uploading new images
  - Adjusting settings (e.g. slideshow delay)

---

## 🚀 Getting Started

### Prerequisites

- Raspberry Pi running Raspberry Pi OS Lite
- Connected display (HDMI or official touchscreen)
- Network access (for the web interface)

### Install Dependencies

```bash
sudo apt update && sudo apt install --no-install-recommends xserver-xorg xinit feh openbox
```

### Set Up Slideshow

Create `~/.xinitrc`:

```bash
nano ~/.xinitrc
```

Paste:

```sh
#!/bin/sh
xset s off
xset -dpms
xset s noblank
feh --quiet --fullscreen --slideshow-delay 10 --randomize /home/pi/Pictures
```

Make it executable:

```bash
chmod +x ~/.xinitrc
```

To automatically start on boot, add to `~/.bash_profile`:

```bash
[[ -z $DISPLAY && $XDG_VTNR -eq 1 ]] && startx
```

### Add Images

Upload image files to `/home/pi/Pictures`.

---

## 🌐 Web Interface (Planned)

A locally hosted website will be available to:

- Upload new images directly to the slideshow folder
- Change basic settings (e.g. slideshow delay)

---

## 🛠 Status

Planning stage. Development has not yet begun. If I was to guess I would say these are the steps ahead:

- Get slideshow functionality up and running
- Create a web interface
- Add customisation functionality
- Think about other OS's / devices / anything else

---

## 📝 License

This project is licensed under the MIT License.
