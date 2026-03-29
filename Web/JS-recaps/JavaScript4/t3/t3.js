const target = document.querySelector('#target');
const now = new Date();
const dateText = now.toLocaleDateString('fi-FI', {
  day: 'numeric',
  month: 'long',
  year: 'numeric',
});
const timeText = now.toLocaleTimeString('fi-FI', {
  hour: '2-digit',
  minute: '2-digit',
});
const testDateTimeText = now.toLocaleTimeString('fi-FI', {
  year: 'numeric',
  month: 'long',
  day: 'numeric',
  hour: '2-digit',
  minute: '2-digit',
});

const browserBrand =
  navigator.userAgentData?.brands?.[2]?.brand || navigator.appName;
const browserVersion =
  navigator.userAgentData?.brands?.[2]?.version || navigator.appVersion;
const osName = navigator.userAgentData?.platform || navigator.platform;

const rows = [
  `Browser: ${browserBrand} ${browserVersion}`,
  `Operating system: ${osName}`,
  `Screen size: ${window.screen.width} x ${window.screen.height}`,
  `Available space: ${window.innerWidth} x ${window.innerHeight}`,
  `Date: ${dateText}`,
  `Time: ${timeText}`,
  `Now: ${testDateTimeText}`,
];

rows.forEach(text => {
  const p = document.createElement('p');
  p.textContent = text;
  target.append(p);
});
