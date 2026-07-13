# Oplus Keyboard Free

An LSPosed module that remaps the Meta key on OnePlus devices.

[English](README.md) | [简体中文](README_zh_CN.md)

---

### Features

On OnePlus devices running ColorOS, the Meta key and various key combinations are mapped to system functions. Mouse middle button is mapped to Home, right button to Back. Android also natively maps Alt + Tab to task switching. This module disables these keyboard shortcuts so remote desktop apps like Parsec can receive native key events.

Fix for mouse button remapping has not been found yet. Please manually enable **“Disable permission monitoring”** in Developer Options to restore normal mouse behavior.

### Compatibility

Developed and tested on a **Xiaomi Pad 5 Pro** running ColorOS 15. Should theoretically support all OnePlus tablets running ColorOS. Compatibility with other ColorOS devices is not guaranteed, please test on your own device.

### Quick Start

- Install a root manager and LSPosed
- Download the module from [Releases](https://github.com/himlijnn/oplus_keyboard_free/releases) and install it
- Reboot and the module works
  - Optionally enable **“Disable permission monitoring”** in Developer Options

### Acknowledgments

- [MiuiPadMeta](https://github.com/CwithW/MiuiPadMeta) - inspiration
