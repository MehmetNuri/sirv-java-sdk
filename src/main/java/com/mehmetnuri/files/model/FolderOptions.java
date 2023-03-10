package com.mehmetnuri.files.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FolderOptions {
    private Boolean scanSpins;
    private Boolean allowListing;
}
