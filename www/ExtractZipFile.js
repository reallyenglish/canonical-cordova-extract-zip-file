/**
 * ZipPlugin.js
 *
 * Phonegap Extract Zip File plugin
 *
 * Created by Shaun Rowe on 10/05/2012.
 * Copyright (c) Pobl Creative Cyf. 2012
 *
 */
var ExtractZipFile = function(){};

cordova.addConstructor(function(){
  if(!window.plugins) window.plugins = {};
  window.plugins.extractZipFile = new ExtractZipFile();
});

ExtractZipFile.prototype.extractFile = function(file, destination, successCallback, errorCallback){
  return cordova.exec(successCallback, errorCallback, "ExtractZipFile", "extract", [file, destination]);
};