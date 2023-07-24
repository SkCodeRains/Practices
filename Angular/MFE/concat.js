const concat = require("concat");

const files = [
  "./dist/mfe-2/runtime.js",
  "./dist/mfe-2/polyfills.js",
  "./dist/mfe-2/main.js"
];
concat(files, "dist/mfe-2/mfe2.js");

