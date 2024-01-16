//
//  AboutDeviceListView.swift
//  iosApp
//
//  Created by abdullah on 16/01/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutDeviceListView:View {
    private struct RowItem:Hashable{
        let title:String
        let subTitle:String
    }
    private let items: [RowItem] = {
        let platform=Platform()
        platform.logSystemInfo()
        var result :[RowItem] = [
            .init(title: "Operating system", subTitle: "\(platform.osName) \(platform.osVersion)"),
            .init(title: "Device", subTitle: platform.deviceModel),
            .init(title: "Density", subTitle: "@\(platform.density)x"),
        ]
        return result
    
    }()
    
    var body: some View{
        List {
            ForEach(items, id: \.self){item in
                VStack(alignment: .leading){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subTitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical,4)
                
            }
        }
    }
}

