package com.mehmetnuri.files.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FolderContent {
    List<Content> contents;
}
