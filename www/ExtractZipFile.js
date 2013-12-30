/**
 * ExtractZipFile.js
 *
 * Adapted for Cordova > 3.0.0 from Phonegap Extract Zip File plugin
 * following instructions here:
 * http://cordova.apache.org/docs/en/3.3.0/plugin_ref_spec.md.html#Plugin%20Specification_js_module_element
 *
 * Created by Shaun Rowe on 10/05/2012.
 * Copyright (c) Pobl Creative Cyf. 2012
 */

var exec = require('cordova/exec');

var ExtractZipFile = function(){};

ExtractZipFile.prototype.extractFile = function(file, destination, successCallback, errorCallback){
  return exec(successCallback, errorCallback, "ExtractZipFile", "extract", [file, destination]);
};

module.exports = new ExtractZipFile();