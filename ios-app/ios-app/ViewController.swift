//
//  ViewController.swift
//  ios-app
//
//  Created by Jamie Lynch on 30/01/2019.
//  Copyright © 2019 Jamie Lynch. All rights reserved.
//

import UIKit
import main

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    private let languageFacts = LanguageFactRepository().fetchLanguageFacts()
    
    @IBOutlet weak var detailLabel: UILabel!
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        detailLabel.text = PlatformMessageKt.platformMessage()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return languageFacts.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        cell.textLabel?.text = languageFacts[indexPath.row].name
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        detailLabel.text = languageFacts[indexPath.row].component2()
    }
}
